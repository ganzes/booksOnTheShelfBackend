package booksontheshelfbackend.entities;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "date")
    private LocalDate date;

    public Reader() {
    }

    public Reader(long id, String name, long pages, LocalDate date) {
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
