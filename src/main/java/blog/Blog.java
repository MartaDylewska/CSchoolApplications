package blog;

import java.util.List;
import java.util.Objects;

public class Blog {

    private List<User> users;
    private List<Post> posts;

    public Blog(){}

    public Post addPost(int userId, String c){

        Post p = null;
        for(User user : users){
            if(user.getId() == userId){
                p = new Post(user, c);
                posts.add(p);
            }
        }
        return p;
    }

    public void publishPost(int userId, String c){
        Post p = addPost(userId,c);
        if(p == null){
            System.out.println("Cannot publish post - user of id " + userId + " doesn’t exist.");
        }
        else {
            System.out.println(p.getAuthor() + " posted " + p.getPostedDate() + ": " + p.getContent());
        }
    }

    public Comment commentPost(int userId, int postId, String c){
        Comment comment = null;
        User commentAuthor = null;
        for(User user: users){
            if(user.getId() == userId){
                commentAuthor = user;
            }
        }
        for(Post post: posts){
            if (post.getId() == postId ){
                comment = new Comment(commentAuthor, c);
                post.addComment(comment);
            }
        }
        return comment;
    }

    public void publishComment(int userId, int postId, String c){
        Comment comment = commentPost(userId,postId,c);
        if(comment == null){
            System.out.println("Cannot publish comment - user of id " + userId + " doesn’t exist, or post of id " + postId + " doesn't exist");
        }
        else {
            User postAuthor = null;
            for(Post post:posts){
                if(post.getId() == postId){
                    postAuthor = post.getAuthor();
                }
            }
            System.out.println(comment.getAuthor() + " commented "+  postAuthor.getNickName() + "'s post: " + comment.getContent());
        }
    }

    public void displayUserEntries(int userId){
        boolean userExists = false;
        for(User user : users){
            if(user.getId() == userId){
                userExists = true;
                System.out.println(user.getNickName() + "'s entries:");
                for(Post post: posts){
                    if(post.getAuthor().getId() == userId){
                        System.out.println("(POST) " + post.getContent());
                    }
                    List<Comment> comments = post.getComments();
                    for(Comment c: comments){
                        if(c.getAuthor().getId() == userId){
                            System.out.println("(COMMENT) " + c.getContent() );
                        }
                    }
                }
            }
            if(userExists = false){
                System.out.println("User with id " + userId + " doesn't exist");
            }
        }
    }

    /*public List<User> addUserToList(User user){
        boolean userExists = false;
        for(User u: users){
            if(user.getNickName().equals(u.getNickName())){
                userExists = true;
            }
        }
        if(userExists = false){
            System.out.println("User cannot be added = user with the same nickname exists");
        }
        else {
            users.add(user);
        }
        return users;
    }*/

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Blog)) return false;
        Blog blog = (Blog) o;
        return Objects.equals(getUsers(), blog.getUsers()) &&
                Objects.equals(getPosts(), blog.getPosts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsers(), getPosts());
    }

    @Override
    public String toString() {
        return "Blog{" +
                "users=" + users +
                ", posts=" + posts +
                '}';
    }
}
