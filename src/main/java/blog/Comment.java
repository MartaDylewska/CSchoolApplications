package blog;

public class Comment extends Entry{

    public Comment(User author, String content) {
        super(author, content);
    }

    @Override
    public String toString() {
        return "Comment{" + this.getId() + ", user: " + this.getAuthor() + ", content: " + this.getContent()+"}";
    }
}
