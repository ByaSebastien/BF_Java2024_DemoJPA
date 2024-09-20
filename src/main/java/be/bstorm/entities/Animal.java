package be.bstorm.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "animalType")
public abstract class Animal {

    @Id @GeneratedValue
    private Long id;

    private String name;
}
