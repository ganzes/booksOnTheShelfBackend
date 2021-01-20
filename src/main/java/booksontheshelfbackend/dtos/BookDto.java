package booksontheshelfbackend.dtos;

import booksontheshelfbackend.entities.Bookcase;
import booksontheshelfbackend.enums.BookStatusEnum;

public class BookDto {

    private long id;
    private String author;
    private String title;
    private long pages;
    private String comment;
    private BookStatusEnum bookStatusEnum;
    private boolean withdrawn;
    private Bookcase bookcase;

    public BookDto() {
    }

    public BookDto(long id, String author, String title, long pages, String comment, BookStatusEnum bookStatusEnum,
                   boolean withdrawn, Bookcase bookcase) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.comment = comment;
        this.bookStatusEnum = bookStatusEnum;
        this.withdrawn = withdrawn;
        this.bookcase = bookcase;
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

    public Bookcase getBookcase() {
        return bookcase;
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

    public void setBookcase(Bookcase bookcase) {
        this.bookcase = bookcase;
    }
}
