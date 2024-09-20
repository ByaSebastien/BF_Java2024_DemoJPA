package be.bstorm.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@DiscriminatorValue("cat")
public class Cat extends Animal {

    private String breed;
}
