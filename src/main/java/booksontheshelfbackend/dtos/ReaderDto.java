package booksontheshelfbackend.dtos;

import booksontheshelfbackend.entities.Book;
import booksontheshelfbackend.entities.Bookcase;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Set;

public class ReaderDto {

    private long id;
    private String name;
    private long pages;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Set<Book> books;
    private Set<Bookcase> bookcases;

    public ReaderDto() {
    }

    public ReaderDto(long id, String name, long pages, LocalDate date, Set<Book> books, Set<Bookcase> bookcases) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.date = date;
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
        return date;
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

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void setBookcases(Set<Bookcase> bookcases) {
        this.bookcases = bookcases;
    }
}
