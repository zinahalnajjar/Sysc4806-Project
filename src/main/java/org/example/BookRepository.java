package org.example;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

    Book findById(int id);
    void deleteById(int id);
    Iterable<Book> findAll();

}
