package blog;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Blog blog = new Blog();

        List<User> users = new ArrayList<>();

        User mardyl = new User("Marta", "Dylewska", "mardyl");
        User asos = new User("Adam", "Sosinski", "asos");
        User krzymam = new User("Krzysztof", "Mamcarz", "krzymam");
        users.add(mardyl);
        users.add(asos);
        users.add(krzymam);

        blog.setUsers(users);

        List<Post> posts = new ArrayList<>();
        blog.setPosts(posts);

        blog.publishPost(blog.getUsers().get(0).getId(),"Hahaha this is so funny! I just saw a pink cat");
        blog.publishPost(blog.getUsers().get(0).getId(), "What is your biggest life problem?");
        blog.publishPost(blog.getUsers().get(1).getId(), "Can anybody see me?");
        blog.publishPost(blog.getUsers().get(2).getId(), "I'm looking for job");

        blog.publishComment(blog.getUsers().get(2).getId(), blog.getPosts().get(2).getId(),"Hmm what to say...");

        blog.displayUserEntries(blog.getUsers().get(0).getId());
        blog.displayUserEntries(blog.getUsers().get(2).getId());
    }
}
