package booksontheshelfbackend.entities;

import javax.persistence.*;

@Entity(name = "bookcase")
public class Bookcase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "tag")
    private String tag;

    public Bookcase() {
    }

    public Bookcase(long id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public long getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
