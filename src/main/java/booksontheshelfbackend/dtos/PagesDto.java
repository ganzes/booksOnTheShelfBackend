package booksontheshelfbackend.dtos;

import booksontheshelfbackend.entities.Reader;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class PagesDto {
    private long id;
    private long pagesRead;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePagesAdded;
    private Reader reader;

    public PagesDto() {
    }

    public PagesDto(long id, long pagesRead, LocalDate datePagesAdded, Reader reader) {
        this.id = id;
        this.pagesRead = pagesRead;
        this.datePagesAdded = datePagesAdded;
        this.reader = reader;
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
