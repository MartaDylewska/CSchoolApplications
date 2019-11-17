package blog;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Entry {

    private static int counterEntry = 211;

    private int id;
    private LocalDateTime postedDate;
    private User author;
    private String content;

    public Entry(User author, String content) {
        this.id = counterEntry++;
        this.postedDate = LocalDateTime.now();
        this.author = author;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDateTime postedDate) {
        this.postedDate = postedDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;
        Entry entry = (Entry) o;
        return getId() == entry.getId() &&
                Objects.equals(getPostedDate(), entry.getPostedDate()) &&
                Objects.equals(getAuthor(), entry.getAuthor()) &&
                Objects.equals(getContent(), entry.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPostedDate(), getAuthor(), getContent());
    }

    @Override
    public String toString() {
        return content;
    }
}
