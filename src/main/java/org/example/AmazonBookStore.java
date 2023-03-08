package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AmazonBookStore {

    private static final Logger log = LoggerFactory.getLogger(AmazonBookStore.class);
    public static void main(String[] args) {
        SpringApplication.run(AmazonBookStore.class, args);
    }

    @Bean
    public CommandLineRunner repoInfo(UserRepository userRepository, BookRepository bookrepository) {
        return (args) -> {

            User user1 = new User("sam.bauer@gmail.com","1234");
            userRepository.save(user1);
            Book book1 = new Book(1L,"Harry Potter", "isbn", "Rany Hookins", "sara","kjshfkjhdfk", "link to pic", 1, 25);
            bookrepository.save(book1);
            Book book2 = new Book(2L,"twilight", "isbn", "J.KRowling", "sara","kjshfkjhdfk", "link to pic", 1, 19);
            Book book3 = new Book(3L,"games", "isbn", "Bob", "sara","kjshfkjhdfk", "link to pic", 1, 23);
            bookrepository.save(book2);
            bookrepository.save(book3);

            log.info("users found with findAll():");
            log.info("-------------------------------");
            for (User users : userRepository.findAll()) {
                log.info(users.toString());
            }
            log.info("");



        };
    }


        }