package org.example;
import org.example.enums.*;

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
    public CommandLineRunner repoInfo(UserRepository userRepository, BookRepository bookRepository) {
        return (args) -> {

            Book book = new Book(1L, "The Way I Used to Be", 1481449362, "Amber Smith", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 15.58, Language.ENGLISH, Genre.FICTION, Age.R);

            Book book1 = new Book(2L, "The Way I Used to Be", 1481449362, "Jane", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "temp1", 10, 17, Language.ENGLISH, Genre.FICTION, Age.R);

            Book book2 = new Book(3L, "The Way I Used to Be", 1481449362, "Smith", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "temp2", 10, 24, Language.ENGLISH, Genre.FICTION, Age.R);

            Book book3 = new Book(4L, "The Way I Used to Be", 1481449362, "Veronica", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend rapes her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 40, Language.ENGLISH, Genre.FICTION, Age.R);

            Book book4 = new Book(5L, "The Way I Used to Be", 1481449362, "Babak E", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 10, Language.ENGLISH, Genre.FICTION, Age.R);

            Book book5 = new Book(6L, "The Way I Used to Be", 1481449362, "Michael", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 11, Language.ENGLISH, Genre.FICTION, Age.R);

            Book book6 = new Book(7L, "The Way I Used to Be", 1481449362, "John Breton", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 100, Language.ENGLISH, Genre.FICTION, Age.R);

            Book book7 = new Book(8L, "The Way I Used to Be", 1481449362, "Moe Zalat", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 200, Language.ENGLISH, Genre.FICTION, Age.R);

            Book book8 = new Book(9L, "The Way I Used to Be", 1481449362, "Zinah Al Najjar", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 2, Language.ENGLISH, Genre.FICTION, Age.R);

            Book book9 = new Book(10L, "The Way I Used to Be", 1481449362, "Tooba Sheikh", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 1, Language.ENGLISH, Genre.FICTION, Age.R);

            bookRepository.save(book);
            bookRepository.save(book1);
            bookRepository.save(book2);
            bookRepository.save(book3);
            bookRepository.save(book4);
            bookRepository.save(book5);
            bookRepository.save(book6);
            bookRepository.save(book7);
            bookRepository.save(book8);
            bookRepository.save(book9);


            log.info("users found with findAll():");
            log.info("-------------------------------");
            for (Book books : bookRepository.findAll()) {
                log.info(book.toString());
            }
            log.info("");


            User user1 = new User("Sam", "Bauer","sam.bauer@gmail.com","1234");
            userRepository.save(user1);

            log.info("users found with findAll():");
            log.info("-------------------------------");
            for (User users : userRepository.findAll()) {
                log.info(users.toString());
            }
            log.info("");


        };


    }


}