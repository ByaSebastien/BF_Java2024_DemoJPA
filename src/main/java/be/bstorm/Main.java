package be.bstorm;

import be.bstorm.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
        EntityManager em = emf.createEntityManager();

        Book book = new Book("123","test","test","test");
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }
}