package be.bstorm.entities;

import be.bstorm.enums.UserGender;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 123)
    private String firstname;

    @Column(nullable = false,length = 80)
    private String lastname;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate birthdate;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private UserGender gender;

   @Embedded
    private Address address;
}
