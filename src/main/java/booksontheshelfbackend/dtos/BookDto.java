package booksontheshelfbackend.dtos;

import booksontheshelfbackend.entities.Bookcase;
import booksontheshelfbackend.entities.Reader;
import booksontheshelfbackend.enums.BookRatingEnum;
import booksontheshelfbackend.enums.BookStatusEnum;

public class BookDto {

    private long id;
    private String author;
    private String title;
    private long pages;
    private String publisher;
    private String comment;
    private BookStatusEnum bookStatusEnum;
    private BookRatingEnum bookRatingEnum;
    private boolean withdrawn;
    private Bookcase bookcase;
    private Reader reader;

    public BookDto() {
    }

    public BookDto(long id, String author, String title, long pages, String publisher, String comment,
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
