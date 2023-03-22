package org.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book findById(long id);
    void deleteById(int id);
    Iterable<Book> findAll();

    Iterable<Book> findByOrderByPriceDesc();
    Iterable<Book> findByOrderByPriceAsc();

    Iterable<Book> findByOrderByAuthorAsc();

    Iterable<Book> findByOrderByTitleAsc();

    Iterable<Book> findByTitle(String Title);

    Iterable<Book> findByAuthor(String author);

    Iterable<Book> findBySearchAllIgnoreCaseContainingOrderByTitleAsc(String search);
}
