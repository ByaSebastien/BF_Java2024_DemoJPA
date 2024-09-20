package be.bstorm.entities;

import jakarta.persistence.*;

@Entity
public class Mayor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // A Eviter
//    @OneToOne(mappedBy = "mayor")
//    private Municipality municipality;

    public Mayor() {}

    public Mayor(String name) {
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

//    public Municipality getMunicipality() {
//        return municipality;
//    }
//
//    public void setMunicipality(Municipality municipality) {
//        this.municipality = municipality;
//    }

    @Override
    public String toString() {
        return "Mayor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
