package booksontheshelfbackend.dtos;

public class ReaderDto {

    private long id;
    private String name;
    private long pages;

    public ReaderDto() {
    }

    public ReaderDto(long id, String name, long pages) {
        this.id = id;
        this.name = name;
        this.pages = pages;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }
}
