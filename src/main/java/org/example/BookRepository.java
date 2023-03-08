package org.example;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book findById(long id);
    void deleteById(int id);
    Iterable<Book> findAll();

}
