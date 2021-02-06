package booksontheshelfbackend.dtos;

import booksontheshelfbackend.entities.Book;
import booksontheshelfbackend.entities.Reader;

import java.util.Set;

public class BookcaseDto {

    private long id;
    private String tag;
    private Set<Book> books;
    private Reader reader;

    public BookcaseDto() {
    }

    public BookcaseDto(long id, String tag, Set<Book> books, Reader reader) {
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
