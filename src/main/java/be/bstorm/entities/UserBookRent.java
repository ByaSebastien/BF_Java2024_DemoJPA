package be.bstorm.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class UserBookRent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime rentDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private User user;

    public UserBookRent() {
    }

    public UserBookRent(LocalDateTime rentDate, Book book, User user) {
        this();
        this.rentDate = rentDate;
        this.book = book;
        setUser(user);
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDateTime rentDate) {
        this.rentDate = rentDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        user.addRent(this);
    }

    @Override
    public String toString() {
        return "UserBookRent{" +
                "id=" + id +
                ", rentDate=" + rentDate +
                ", book=" + book +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBookRent that = (UserBookRent) o;
        return Objects.equals(id, that.id) && Objects.equals(rentDate, that.rentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentDate);
    }
}
