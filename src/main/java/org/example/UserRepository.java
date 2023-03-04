package org.example;

import org.springframework.data.repository.CrudRepository;




public interface UserRepository extends CrudRepository<User, Long> {
    User findByfName(String FirstName);
    Iterable<User> findAll();

}
