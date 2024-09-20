package be.bstorm.repositories.impls;

import be.bstorm.entities.Book;
import be.bstorm.repositories.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {

    private final EntityManagerFactory emf;

    public BookRepositoryImpl() {
        this.emf = Persistence.createEntityManagerFactory("DemoJPA");
    }

    @Override
    public List<Book> findAll() {

        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        }
    }

    @Override
    public Optional<Book> findById(Long id) {

        try (EntityManager em = emf.createEntityManager()) {
            Book book = em.find(Book.class, id);
            return Optional.of(book);
        }
    }

    @Override
    public Book save(Book book) {

        try (EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
        }

        return book;
    }

    @Override
    public void update(Long id, Book book) {

        try (EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();

            Book existingBook = em.find(Book.class, id);

            if (existingBook != null) {
                existingBook.setIsbn(book.getIsbn());
                existingBook.setTitle(book.getTitle());
                existingBook.setAuthor(book.getAuthor());
                existingBook.setDescription(book.getDescription());
            }

            em.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {

        try (EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();
            Book book = em.find(Book.class, id);
            if (book != null) {
                em.remove(book);
            }
            em.getTransaction().commit();
        }
    }
}
