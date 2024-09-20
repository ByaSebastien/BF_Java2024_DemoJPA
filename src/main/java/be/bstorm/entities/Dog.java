package be.bstorm.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@DiscriminatorValue("dog")
public class Dog extends Animal {

    private String breed;
}
