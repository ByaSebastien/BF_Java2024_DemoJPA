package be.bstorm.entities;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Municipality {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Mayor mayor;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    @JoinColumn(name = "pro_id")
    private Province province;

    public Municipality() {}

    public Municipality(String name, Mayor mayor, Province province) {
        this();
        this.name = name;
        this.mayor = mayor;
        this.province = province;
//        setMayor(mayor);
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

    public Mayor getMayor() {
        return mayor;
    }

    public void setMayor(Mayor mayor) {
//        mayor.setMunicipality(this);
        this.mayor = mayor;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Municipality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mayor=" + mayor +
                ", province=" + province +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Municipality that = (Municipality) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
