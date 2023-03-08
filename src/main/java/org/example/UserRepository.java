package org.example;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findById(long userId);
    User findByEmail(String email);
    Iterable<User> findAll();

}
