package be.bstorm;

import be.bstorm.entities.*;
import be.bstorm.repositories.BookRepository;
import be.bstorm.repositories.impls.BookRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BookRepository bookRepository = new BookRepositoryImpl();

        Book book = new Book(
                "123",
                "test",
                "author",
                "..."
        );

        Book book2 = new Book(
                "456",
                "test2",
                "author2",
                "..."
        );

        bookRepository.save(book);
        bookRepository.save(book2);

        bookRepository.findAll().forEach(System.out::println);

        Book result = bookRepository.findById(1L).orElseThrow();

        System.out.println("___________________________________________");
        System.out.println(result);

        result.setTitle("Modif");

        bookRepository.update(1L,result);

        System.out.println("___________________________________________");
        bookRepository.findAll().forEach(System.out::println);

        bookRepository.deleteById(1L);
        System.out.println("___________________________________________");
        bookRepository.findAll().forEach(System.out::println);

//        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA")) {
//
//            try (EntityManager em = emf.createEntityManager()) {
//
//                Mayor mayor = new Mayor("Truc");
//                Province province = new Province("Prov");
//                Municipality municipality = new Municipality("Commune", mayor, province);
//
//                em.getTransaction().begin();
//
//                em.persist(municipality);
//
//                em.getTransaction().commit();
//            }
//
//            try (EntityManager em = emf.createEntityManager()) {
//
//                Municipality municipality = em.find(Municipality.class, 1L);
//
//                System.out.println(municipality);
//
//            }
//
//            try (EntityManager em = emf.createEntityManager()) {
//
//                Mayor mayor = em.find(Mayor.class, 1L);
//
//                TypedQuery<Municipality> query = em.createQuery("select mu from Municipality mu join mu.mayor where mu.mayor.id = :id", Municipality.class);
//
//                query.setParameter("id", mayor.getId());
//
//                Municipality municipality = query.getSingleResult();
//
//                System.out.println(municipality);
//
//            }
//        }


    }
}