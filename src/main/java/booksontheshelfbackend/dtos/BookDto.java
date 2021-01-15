package booksontheshelfbackend.dtos;

public class BookDto {

    private long id;
    private String author;
    private String title;
    private long pages;
    private String comment;
    private boolean withdrawn;

    public BookDto() {
    }

    public BookDto(long id, String author, String title, long pages, String comment, boolean withdrawn) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.comment = comment;
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

    public long getPages() {
        return pages;
    }

    public String getComment() {
        return comment;
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

    public void setPages(long pages) {
        this.pages = pages;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setWithdrawn(boolean withdrawn) {
        this.withdrawn = withdrawn;
    }
}
