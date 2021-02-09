package booksontheshelfbackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "pages")
public class Pages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "pagesread")
    private long pagesRead;

    @CreatedDate
    @Column(name = "datepagesadded", columnDefinition = "timestamp")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePagesAdded;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reader_id")
    @JsonBackReference(value = "reader_pages")
    private Reader reader;

    public Pages() {
    }

    public Pages(long id, long pagesRead, LocalDate datePagesAdded, Reader reader) {
        this.id = id;
        this.pagesRead = pagesRead;
        this.datePagesAdded = datePagesAdded;
        this.reader = reader;
    }

    public Pages(long pagesRead) {
        this.pagesRead = pagesRead;
    }

    public long getId() {
        return id;
    }

    public long getPagesRead() {
        return pagesRead;
    }

    public LocalDate getDatePagesAdded() {
        return LocalDate.now();
    }

    public Reader getReader() {
        return reader;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPagesRead(long pagesRead) {
        this.pagesRead = pagesRead;
    }

    public void setDatePagesAdded(LocalDate datePagesAdded) {
        this.datePagesAdded = datePagesAdded;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
