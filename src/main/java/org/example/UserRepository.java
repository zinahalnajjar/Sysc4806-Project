package org.example;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByfName(String FirstName);
    User findByID(long id);
    Iterable<User> findAll();

}
