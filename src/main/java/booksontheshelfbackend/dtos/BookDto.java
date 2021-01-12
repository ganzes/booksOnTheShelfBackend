package booksontheshelfbackend.dtos;

public class BookDto {

    private long id;
    private String author;
    private String title;
    private boolean withdrawn;

    public BookDto() {
    }

    public BookDto(long id, String author, String title, boolean withdrawn) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.withdrawn = withdrawn;
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

    public boolean isWithdrawn() {
        return withdrawn;
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

    public void setWithdrawn(boolean withdrawn) {
        this.withdrawn = withdrawn;
    }
}
