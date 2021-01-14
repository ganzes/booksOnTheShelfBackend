package booksontheshelfbackend.entities;

import javax.persistence.*;

@Entity(name = "bookcase")
public class Bookcase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    public Bookcase() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
