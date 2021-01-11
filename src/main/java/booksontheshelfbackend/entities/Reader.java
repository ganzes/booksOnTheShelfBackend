package booksontheshelfbackend.entities;

import javax.persistence.*;

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

}
