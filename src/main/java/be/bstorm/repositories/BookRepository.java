package be.bstorm.repositories;

import be.bstorm.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book save(Book book);
    void update(Long id, Book book);
    void deleteById(Long id);
}
