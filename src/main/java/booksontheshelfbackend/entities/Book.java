package booksontheshelfbackend.entities;

import booksontheshelfbackend.enums.BookStatusEnum;

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

    @Column(name = "comment")
    private String comment;

    @Enumerated(EnumType.STRING)
    private BookStatusEnum bookStatusEnum;

    @Column(name = "withdrawn")
    private boolean withdrawn;

    public Book() {
    }

    public Book(long id, String author, String title, long pages, String comment, BookStatusEnum bookStatusEnum,
                boolean withdrawn) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.comment = comment;
        this.bookStatusEnum = bookStatusEnum;
        this.withdrawn = withdrawn;
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

    public String getComment() {
        return comment;
    }

    public BookStatusEnum getBookStatusEnum() {
        return bookStatusEnum;
    }

    public boolean isWithdrawn() {
        return withdrawn;
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

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setBookStatusEnum(BookStatusEnum bookStatusEnum) {
        this.bookStatusEnum = bookStatusEnum;
    }

    public void setWithdrawn(boolean withdrawn) {
        this.withdrawn = withdrawn;
    }
}
