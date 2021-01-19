package booksontheshelfbackend.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "bookcase")
public class Bookcase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "tag")
    private String tag;

    @OneToMany(mappedBy = "bookcase", fetch = FetchType.EAGER)
    private Set<Book> books;

    public Bookcase() {
    }

    public Bookcase(long id, String tag, Set<Book> books) {
        this.id = id;
        this.tag = tag;
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
