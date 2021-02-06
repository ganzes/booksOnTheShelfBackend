package booksontheshelfbackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @JsonManagedReference(value = "book_bookcase")
    private Set<Book> books;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reader_id")
    @JsonBackReference(value = "reader_bookcase")
    private Reader reader;

    public Bookcase() {
    }

    public Bookcase(long id, String tag, Set<Book> books, Reader reader) {
        this.id = id;
        this.tag = tag;
        this.books = books;
        this.reader = reader;
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

    public Reader getReader() {
        return reader;
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

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
