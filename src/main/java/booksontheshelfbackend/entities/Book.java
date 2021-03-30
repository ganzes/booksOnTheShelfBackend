package booksontheshelfbackend.entities;

import booksontheshelfbackend.enums.BookRatingEnum;
import booksontheshelfbackend.enums.BookStatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "pages")
    private long pages;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "comment")
    private String comment;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookStatusEnum bookStatusEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "rating")
    private BookRatingEnum bookRatingEnum;

    @Column(name = "withdrawn")
    private boolean withdrawn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bookcase_id")
    @JsonBackReference(value = "book_bookcase")
    private Bookcase bookcase;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reader_id")
    @JsonBackReference(value = "reader_books")
    private Reader reader;

    public Book() {
    }

    public Book(long id, String author, String title, long pages, String publisher, String comment,
                BookStatusEnum bookStatusEnum, BookRatingEnum bookRatingEnum, boolean withdrawn,
                Bookcase bookcase, Reader reader) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.publisher = publisher;
        this.comment = comment;
        this.bookStatusEnum = bookStatusEnum;
        this.bookRatingEnum = bookRatingEnum;
        this.withdrawn = withdrawn;
        this.bookcase = bookcase;
        this.reader = reader;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public long getPages() {
        return pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getComment() {
        return comment;
    }

    public BookStatusEnum getBookStatusEnum() {
        return bookStatusEnum;
    }

    public BookRatingEnum getBookRatingEnum() {
        return bookRatingEnum;
    }

    public boolean isWithdrawn() {
        return withdrawn;
    }

    public Bookcase getBookcase() {
        return bookcase;
    }

    public Reader getReader() {
        return reader;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setBookStatusEnum(BookStatusEnum bookStatusEnum) {
        this.bookStatusEnum = bookStatusEnum;
    }

    public void setBookRatingEnum(BookRatingEnum bookRatingEnum) {
        this.bookRatingEnum = bookRatingEnum;
    }

    public void setWithdrawn(boolean withdrawn) {
        this.withdrawn = withdrawn;
    }

    public void setBookcase(Bookcase bookcase) {
        this.bookcase = bookcase;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
