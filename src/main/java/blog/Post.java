package blog;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Post extends Entry {

    private List<Comment> comments = new ArrayList<>();

    public Post(User author, String content) {
        super(author, content);
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        if (!super.equals(o)) return false;
        Post post = (Post) o;
        return Objects.equals(getComments(), post.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getComments());
    }

    @Override
    public String toString() {
        return "Post{" +
                "comments=" + comments +
                '}';
    }
}
