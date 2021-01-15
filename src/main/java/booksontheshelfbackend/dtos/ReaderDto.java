package booksontheshelfbackend.dtos;

import java.time.LocalDate;

public class ReaderDto {

    private long id;
    private String name;
    private long pages;
    private LocalDate date;

    public ReaderDto() {
    }

    public ReaderDto(long id, String name, long pages, LocalDate date) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.date = date;
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
}
