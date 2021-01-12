package booksontheshelfbackend.dtos;

public class BookDto {

    private long id;
    private String author;
    private String title;
    private boolean wthdrawn;

    public BookDto() {
    }

    public BookDto(long id, String author, String title, boolean wthdrawn) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.wthdrawn = wthdrawn;
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

    public boolean isWthdrawn() {
        return wthdrawn;
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

    public void setWthdrawn(boolean wthdrawn) {
        this.wthdrawn = wthdrawn;
    }
}
