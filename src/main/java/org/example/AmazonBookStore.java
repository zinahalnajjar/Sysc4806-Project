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
    public CommandLineRunner repoInfo(BookRepository bookRepository) {
        return (args) -> {

            Book book = new Book(1L, "The Way I Used to Be", 1481449362, "Amber Smith", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                    "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 15.58, "English", "Fiction", "15+");

            Book book1 = new Book(2L, "The Way I Used to Be", 1481449362, "Amber Smith", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 15.58, "English", "Fiction", "15+");

            Book book2 = new Book(3L, "The Way I Used to Be", 1481449362, "Amber Smith", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 15.58, "English", "Fiction", "15+");

            Book book3 = new Book(4L, "The Way I Used to Be", 1481449362, "Amber Smith", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend rapes her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 15.58, "English", "Fiction", "15+");

            Book book4 = new Book(5L, "The Way I Used to Be", 1481449362, "Amber Smith", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 15.58, "English", "Fiction", "15+");

            Book book5 = new Book(6L, "The Way I Used to Be", 1481449362, "Amber Smith", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 15.58, "English", "Fiction", "15+");

            Book book6 = new Book(7L, "The Way I Used to Be", 1481449362, "Amber Smith", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 15.58, "English", "Fiction", "15+");

            Book book7 = new Book(8L, "The Way I Used to Be", 1481449362, "Amber Smith", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 15.58, "English", "Fiction", "15+");

            Book book8 = new Book(9L, "The Way I Used to Be", 1481449362, "Amber Smith", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 15.58, "English", "Fiction", "15+");

            Book book9 = new Book(10L, "The Way I Used to Be", 1481449362, "Amber Smith", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 15.58, "English", "Fiction", "15+");

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
        };
    }
}