package booksontheshelfbackend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    @Column(name = "datecreaderreated", columnDefinition = "timestamp", nullable = false)
    private LocalDate dateReaderCreated;

    @OneToMany(mappedBy = "reader", fetch = FetchType.EAGER)
    @JsonManagedReference(value = "reader_books")
    private Set<Book> books;

    @OneToMany(mappedBy = "reader", fetch = FetchType.EAGER)
    @JsonManagedReference(value = "reader_bookcase")
    private Set<Bookcase> bookcases;

    public Reader() {
    }

    public Reader(long id, String name, long pages, LocalDate dateReaderCreated,
                  Set<Book> books, Set<Bookcase> bookcases) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.dateReaderCreated = dateReaderCreated;
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

    public LocalDate getDateReaderCreated() {
        return dateReaderCreated;
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

    public void setDateReaderCreated(LocalDate dateReaderCreated) {
        this.dateReaderCreated = dateReaderCreated;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void setBookcases(Set<Bookcase> bookcases) {
        this.bookcases = bookcases;
    }
}
