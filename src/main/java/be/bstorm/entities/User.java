package be.bstorm.entities;

import be.bstorm.enums.UserGender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(
        name = "user_",
        uniqueConstraints = {@UniqueConstraint(
                name = "uk_user__firstname__lastname",
                columnNames = {"first_name", "last_name"}
        )})
@NamedQueries({
        @NamedQuery(
                name = "findAllUser",
                query = "select u from User u"
        )
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 123, name = "first_name")
    private String firstname;

    @Column(nullable = false, length = 80, name = "last_name")
    private String lastname;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate birthdate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserGender gender;

    @Embedded
    private Address address;

    // Discutable
    @OneToMany(mappedBy = "user")
    private final Set<UserBookRent> rents;

    public User(){
        this.rents = new HashSet<>();
    }

    public User(String firstname, String lastname, LocalDate birthdate, UserGender gender, Address address) {
        this();
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public UserGender getGender() {
        return gender;
    }

    public void setGender(UserGender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<UserBookRent> getRents() {
        return Set.copyOf(this.rents);
    }

    public void addRent(UserBookRent rent) {
        this.rents.add(rent);
    }

    public void removeRent(UserBookRent rent) {
        this.rents.remove(rent);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate=" + birthdate +
                ", gender=" + gender +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }
}
