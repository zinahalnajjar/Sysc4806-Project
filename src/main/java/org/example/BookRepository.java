package org.example;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book findById(long id);
    void deleteById(long id);
    Iterable<Book> findAll();

    Iterable<Book> findByOrderByCostDesc();

    Iterable<Book> findByOrderByAuthorAsc();

}
