package be.bstorm.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Province {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // A eviter
//    @OneToMany(mappedBy = "province")
//    private Set<Municipality> municipalities;

    public Province() {}

    public Province(String name) {
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
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
