package be.bstorm.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class UserBookFavorite {

    @EmbeddedId
    private UserBookFavoriteId id;

    @Column(nullable = false)
    private int rating;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("bookId")
    private Book book;

    public UserBookFavorite() {}

    public UserBookFavorite(int rating, User user, Book book) {
        this();
        this.rating = rating;
        this.user = user;
        this.book = book;
    }

    public UserBookFavoriteId getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "UserBookFavorite{" +
                "id=" + id +
                ", rating=" + rating +
                ", user=" + user +
                ", book=" + book +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBookFavorite that = (UserBookFavorite) o;
        return rating == that.rating && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating);
    }

    @Embeddable
    public static class UserBookFavoriteId {

        private Long userId;
        private Long bookId;
    }
}
