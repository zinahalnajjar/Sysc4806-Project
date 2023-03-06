package org.example;

import org.springframework.data.repository.CrudRepository;




public interface UserRepository extends CrudRepository<User, Long> {
    User findByfirstName(String FirstName);
    Iterable<User> findAll();

}
