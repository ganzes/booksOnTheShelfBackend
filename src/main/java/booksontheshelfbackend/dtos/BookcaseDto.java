package booksontheshelfbackend.dtos;

import booksontheshelfbackend.entities.Book;

import java.util.Set;

public class BookcaseDto {

    private long id;
    private String tag;
    private Set<Book> books;

    public BookcaseDto() {
    }

    public BookcaseDto(long id, String tag, Set<Book> books) {
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
