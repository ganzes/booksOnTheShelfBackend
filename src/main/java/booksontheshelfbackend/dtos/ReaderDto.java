package booksontheshelfbackend.dtos;

import booksontheshelfbackend.entities.Book;
import booksontheshelfbackend.entities.Bookcase;
import booksontheshelfbackend.entities.Pages;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Set;

public class ReaderDto {

    private long id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateReaderCreated;
    private Set<Pages> pages;
    private Set<Book> books;
    private Set<Bookcase> bookcases;

    public ReaderDto() {
    }

    public ReaderDto(long id, String name, LocalDate dateReaderCreated, Set<Pages> pages, Set<Book> books, Set<Bookcase> bookcases) {
        this.id = id;
        this.name = name;
        this.dateReaderCreated = dateReaderCreated;
        this.pages = pages;
        this.books = books;
        this.bookcases = bookcases;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateReaderCreated() {
        return LocalDate.now();
    }

    public Set<Pages> getPages() {
        return pages;
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

    public void setDateReaderCreated(LocalDate dateReaderCreated) {
        this.dateReaderCreated = dateReaderCreated;
    }

    public void setPages(Set<Pages> pages) {
        this.pages = pages;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void setBookcases(Set<Bookcase> bookcases) {
        this.bookcases = bookcases;
    }
}
