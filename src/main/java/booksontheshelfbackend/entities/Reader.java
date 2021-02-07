package booksontheshelfbackend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "reader")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "pages")
    private long pages;

    @Column(name = "date")
    private LocalDate date;

    @OneToMany(mappedBy = "reader", fetch = FetchType.EAGER)
    @JsonManagedReference(value = "reader_books")
    private Set<Book> books;

    @OneToMany(mappedBy = "reader", fetch = FetchType.EAGER)
    @JsonManagedReference(value = "reader_bookcase")
    private Set<Bookcase> bookcases;

    public Reader() {
    }

    public Reader(long id, String name, long pages, LocalDate date, Set<Book> books, Set<Bookcase> bookcases) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.date = LocalDate.now();
        this.books = books;
        this.bookcases = bookcases;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPages() {
        return pages;
    }

    public LocalDate getDate() {
        return LocalDate.now();
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Set<Bookcase> getBookcases() {
        return bookcases;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setBookcases(Set<Bookcase> bookcases) {
        this.bookcases = bookcases;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
