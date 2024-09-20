package be.bstorm.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // A eviter
//    @ManyToMany(mappedBy = "instruments")
//    private Set<Musician> musicians;

    public Instrument(){}

    public Instrument(String name) {
        this();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
