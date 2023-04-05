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

            //Harry Potter Sets - Fiction
            Book book = new Book(1L, "The Way I Used to Be", 1481449362, "Amber Smith", "Margaret K. McElderry Books",
                    "Eden was always good at being good. Starting high school didn’t change who she was. But the night her brother’s best friend hurt her, Eden’s world capsizes.\n" +
                            "\n" + "What was once simple, is now complex.",  "thewayIusedtobe", 10, 15.58, Language.ENGLISH, Genre.FICTION, Age.R);

            Book book1 = new Book(2L, "Harry Potter and the Philosophers Stone", 1481449362, "J.K. Rowling", "Bloomsbury Children's Books",
                    "Harry Potter has never even heard of Hogwarts when the letters start dropping on the doormat at number four, Privet Drive. Addressed in green ink on yellowish " +
                            "parchment with a purple seal, they are swiftly confiscated by his grisly aunt and uncle. \n",
                    "HarryPotter1", 10, 24.00, Language.ENGLISH, Genre.FICTION, Age.PG_13);

            Book book2 = new Book(3L, "Harry Potter and the Chamber of Secrets", 1481449362, "J.K. Rowling", "Bloomsbury Children's Books",
                    "Harry Potter's summer has included the worst birthday ever, doomy warnings from a house-elf called Dobby, and rescue from the Dursleys by his friend " +
                            "Ron Weasley in a magical flying car!",
                    "HarryPotter2", 10, 24.00, Language.ENGLISH, Genre.FICTION, Age.PG_13);

            Book book3 = new Book(4L, "Harry Potter and the Goblet of Fire", 1481449362, "J.K. Rowling", "Bloomsbury Children's Books",
                    "Cedric Dies T_T",
                    "HarryPotter4", 10, 51.65, Language.ENGLISH, Genre.FICTION, Age.PG_13);

            Book book4 = new Book(5L, "Harry Potter and Order of Phoenix", 1481449362, "J.K. Rowling", "Bloomsbury Children's Books",
                    "Dumbledore's Army!!!!!!!!!! Dumbledore Escapes Imprisonment",
                    "HarryPotter5", 10, 51.65, Language.ENGLISH, Genre.FICTION, Age.PG_13);

            Book book5 = new Book(6L, "Harry Potter and the Half - Blood Prince", 1481449362, "J.K. Rowling", "Bloomsbury Children's Books",
                    "Dumbledore Dies!!!!!!",
                    "HarryPotter6", 10, 51.65, Language.ENGLISH, Genre.FICTION, Age.PG_13);

            Book book6 = new Book(7L, "Harry Potter and the Prisoner of Azkaban", 1481449362, "J.K. Rowling", "Bloomsbury Children's Books",
                    "Professor Lupin is a werewolf, Ron's pet rat is Peter Peterigrew, Sirius black is a criminal and Harry's godfather!!!",
                    "HarryPotter4", 10, 24.65, Language.ENGLISH, Genre.FICTION, Age.PG_13);

            Book book7 = new Book(8L, "Harry Potter and the Deathly Hollows", 1481449362, "J.K. Rowling", "Bloomsbury Children's Books",
                    "Harry Potter wins, Voldemort dies.",
                    "HarryPotter7", 10, 51.65, Language.ENGLISH, Genre.FICTION, Age.PG_13);


            Book book17 = new Book(18L, "Harry Potter 8-Pack Set", 1481449362, "J.K. Rowling", "Bloomsbury Children's Books",
                    "Harry Potter Series",
                    "HarryPotterSet", 10, 250, Language.ENGLISH, Genre.FICTION, Age.PG_13);

            //The Selection Series - Romance
            Book book8 = new Book(9L, "The Selection", 1481449362, "Kiera Cass", "Bloomsbury Children's Books",
                    "A poor girl destined to be stuck in poverty gets chosen to be part of the selection process for the future queen!!",
                    "Selection1", 10, 30, Language.ENGLISH, Genre.ROMANCE, Age.PG_13);

            Book book9 = new Book(10L, "The Elite", 1481449362, "Kiera Cass", "Bloomsbury Children's Books",
                    "The main charcter makes it into the top selections",
                    "Selection2", 10, 11, Language.ENGLISH, Genre.ROMANCE, Age.PG_13);

            Book book10 = new Book(11L, "The One", 1481449362, "Kiera Cass", "Bloomsbury Children's Books",
                    "The main character finally gets selected.",
                    "Selection3", 10, 5.65, Language.ENGLISH, Genre.ROMANCE, Age.PG_13);

            Book book11 = new Book(12L, "The Heir", 1481449362, "Kiera Cass", "Bloomsbury Children's Books",
                    "THe main characters, has a daughter who has to go through the same process. The daughter messes up badly",
                    "Selection4", 10, 7, Language.ENGLISH, Genre.ROMANCE, Age.PG_13);

            Book book33 = new Book(34L, "Selection Series 4 Set", 1481449362, "Kiera Cass", "Bloomsbury Children's Books",
                    "All the books combined - Good deal",
                    "SelectionSet", 10, 100, Language.ENGLISH, Genre.ROMANCE, Age.PG_13);

            //History Books
            Book book12 = new Book(13L, "History: From the Dawn of Civilization to the Present Day", 1481449362, "Smithsonian Institution", "DK",
                    "This comprehensive and compelling visual encyclopedia tells the story of our world in true depth and detail, from the origins of life on Earth right up until the 21st century.",
                    "History1", 10, 65.00, Language.ENGLISH, Genre.HISTORY, Age.PG);

            Book book13 = new Book(14L, "History of the World: Map by Map", 1481449362, "DK", "Smithsonian Institution",
                    "Breaking down the world, one area at a time, a thrilling history",
                    "History2", 10, 70, Language.ENGLISH, Genre.HISTORY, Age.PG);

            Book book14 = new Book(15L, "A Short History of Nearly Everything", 1481449362, "Bill Bryson", "Anchor Canada",
                    "The ultimate eye-opening journey through time and space, A Short History of Nearly Everything is the biggest-selling popular science book of the 21st century, " +
                            "and reveals the world in a way most of us have never seen it before.",
                    "History3", 10, 24.00, Language.ENGLISH, Genre.HISTORY, Age.PG);

            Book book15 = new Book(16L, "Sapiens: A Brief History of Humankind", 1481449362, "Yuval Noah Harari ", "A Brief History Series",
                    "How did our species succeed in the battle for dominance? Why did our foraging ancestors come together to create cities and kingdoms?",
                    "History4", 10, 23, Language.ENGLISH, Genre.HISTORY, Age.PG);


            //Fantasy Books
            Book book16 = new Book(17L, "Dellia", 1481449362, "David Scidmore ", "Meerdon Publishing",
                    "Dellia is an epic high-fantasy romance about ordinary people thrust into extraordinary circumstances. " +
                            "It blends alternate worlds, action, adventure, and dire peril, with political intrigue," +
                            "a generous dollop of romance, and a pinch of humor.",
                    "Fantasy1", 10, 12.99, Language.ENGLISH, Genre.FANTASY, Age.PG_13);

            Book book18 = new Book(19L, "Rise of the Immortal: (Path of the Ranger)", 1481449362, "Pedro Urvi", "Independently published",
                    "There are political interests at play, and certain kingdoms and factions do not look favorably on the new alliance between Norghana and Irinel. ",
                    "Fantasy2", 10, 15.45, Language.ENGLISH, Genre.FANTASY, Age.PG_13);

            Book book19 = new Book(20L, "The Word Guardians: and the Shadow Readers", 1481449362, "Lawrence Yarham", "Lawrence Yarham",
                    "One man’s name is on everyone’s lips, Index. Orfeo’s creation, from the Four Horsemen of the Apocalypse, he’s everywhere and nowhere. " +
                            "He’s behind a revolution in the streets and the powers that be. ",
                    "Fantasy3", 10, 13.99, Language.ENGLISH, Genre.FANTASY, Age.PG_13);

            Book book20 = new Book(21L, "The Art of World Building Workbook: Fantasy Edition", 1481449362, "Randy Ellefson", "Evermore Press",
                    "The Art of World Building Workbook: Fantasy Edition is designed to inspire world builders to write down their ideas in a physical book that can be taken wherever they go. " +
                            "Filled with writing prompts and plenty of room to expand",
                    "Fantasy4", 10, 29.99, Language.ENGLISH, Genre.FANTASY, Age.PG_13);

            //Kids Books
            Book book21 = new Book(22L, "My First Book of Planets: All About the Solar System for Kids", 1481449362, "Bruce Betts PhD", "Rockridge Press",
                    "Get even the smallest astronomer excited for the big universe of space, from the bright and burning sun to our own blue Earth to ice-capped Pluto and every planet in between.",
                    "Kids1", 10, 16.65, Language.ENGLISH, Genre.KIDS, Age.G);

            Book book22 = new Book(23L, "How to Draw Book for Kids: A Simple Step-by-Step Guide to Drawing Cute Animals, Cool Vehicles, Food, Plants and So Much More", 1481449362, "Muso Press", "Independently published",
                    "The 101 short drawing lessons in the book are great for young artists, birthday gifts, homeschool art lessons, and elementary art classes.",
                    "Kids2", 10, 7.99, Language.ENGLISH, Genre.KIDS, Age.G);

            Book book23 = new Book(24L, "Jokes for Kids: The Best Jokes, Riddles, Tongue Twisters, Knock-Knock jokes, and One liners for kids", 1481449362, "Rob Stevens ", "CreateSpace",
                    "Chock full of hilarious jokes wisecracks, riddles, and knock-knock jokes, Jokes for Kids is for young readers—and their parents!",
                    "Kids3", 10, 8.50, Language.ENGLISH, Genre.KIDS, Age.G);

            Book book24 = new Book(25L, "I'm a T. Rex!", 1481449362, "Dennis R. Shealy", "Golden Books",
                    "In this brand-new Little Golden Book, a T. rex tells all about his great and terrible self. Facts about the T. rex are humorously presented: Does the T stand for toothy?",
                    "Kids4", 10, 4.15, Language.ENGLISH, Genre.KIDS, Age.G);

            //Horror
            Book book25 = new Book(26L, "The Shining", 1481449362, "Stephen King", "Image Comics",
                    "Jack Torrance’s new job at the Overlook Hotel is the perfect chance for a fresh start. As the off-season caretaker " +
                            "at the atmospheric old hotel, he’ll have plenty of time to spend reconnecting with his family and working on his writing. ",
                    "Horror1", 10, 9.15, Language.ENGLISH, Genre.HORROR, Age.R);

            Book book26 = new Book(27L, "The Walking Dead", 1481449362, "Robert Kirkman", "Bloomsbury Children's Books",
                    "This hardcover features the first 12 issues of the hit series along with the covers for the issues in one oversized hardcover volume. Perfect for long time fans, new " +
                            "readers.",
                    "Horror2", 10, 46.50, Language.ENGLISH, Genre.HORROR, Age.R);

            Book book27 = new Book(28L, "The Graveyard Book", 1481449362, "Neil Gaiman", "HarperCollins",
                    "Bod is an unusual boy who inhabits an unusual place—he's the only living resident of a graveyard. Raised from infancy by the ghosts, werewolves, and other cemetery denizens, " +
                            "Bod has learned the antiquated customs of his guardians' time",
                    "Horror3", 10, 18.60, Language.ENGLISH, Genre.HORROR, Age.R);

            Book book28 = new Book(29L, "Chthonic Matter Quarterly", 1481449362, "C.M. Muller", "Independently published",
                    "Chthonic Matter is a quarterly offering of tales from the darkside. Its contents range in tone from the quiet horror of Shirley Jackson to the bleak stylings of Thomas Ligotti —" +
                            " and everything in between.",
                    "Horror4", 10, 17.82, Language.ENGLISH, Genre.HORROR, Age.R);

            //Young Adult
            Book book29 = new Book(30L, "Tell Me Three Things", 1481449362, "Julie Buxbaum ", "Ember; Reprint edition",
                    "Here are three things about this book: (1) It’s funny and romantic; (2) the mystery at the heart of the story will keep you turning the pages; " +
                            "(3) I have a feeling you’ll be very happy you read it",
                    "Young_Adult3", 10, 9.27, Language.ENGLISH, Genre.YOUNG_ADULT, Age.PG_13);

            Book book30 = new Book(31L, "Every Last Word", 1481449362, "Tamara Ireland Stone ", " Little, Brown Books for Young Readers",
                    "Samantha McAllister looks just like the rest of the popular girls in her junior class. But hidden beneath the straightened hair and expertly applied makeup is a " +
                            "secret that her friends would never understand",
                    "Young_Adult4", 10, 13.19, Language.ENGLISH, Genre.YOUNG_ADULT, Age.PG_13);

            Book book31 = new Book(32L, "Educated: A Memoir", 1481449362, "Tara Westover", "Random House",
                    "Born to survivalists in the mountains of Idaho, Tara Westover was seventeen the first time she set foot in a classroom. Her family was so isolated from mainstream " +
                            "society that there was no one to ensure the children received an education.",
                    "Young_Adult1", 10, 32.14, Language.ENGLISH, Genre.YOUNG_ADULT, Age.R);

            Book book32 = new Book(33L, "Five Feet Apart", 1481449362, "Rachael Lippincott", "Simon & Schuster Books",
                    "Stella Grant likes to be in control—even though her totally out of control lungs have sent her in and out of the hospital most of her life.",
                    "Young_Adult2", 10, 20.09, Language.ENGLISH, Genre.YOUNG_ADULT, Age.PG_13);

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
            bookRepository.save(book10);
            bookRepository.save(book11);
            bookRepository.save(book12);
            bookRepository.save(book13);
            bookRepository.save(book14);
            bookRepository.save(book15);
            bookRepository.save(book16);
            bookRepository.save(book17);
            bookRepository.save(book18);
            bookRepository.save(book19);
            bookRepository.save(book20);
            bookRepository.save(book21);
            bookRepository.save(book22);
            bookRepository.save(book23);
            bookRepository.save(book24);
            bookRepository.save(book25);
            bookRepository.save(book26);
            bookRepository.save(book27);
            bookRepository.save(book28);
            bookRepository.save(book29);
            bookRepository.save(book30);
            bookRepository.save(book31);
            bookRepository.save(book32);
            bookRepository.save(book33);


            log.info("users found with findAll():");
            log.info("-------------------------------");
            for (Book books : bookRepository.findAll()) {
                log.info(book.toString());
            }
            log.info("");


            User user1 = new User("Sam", "Bauer","sam.bauer@gmail.com","1234");
            user1.addPurchased(book1);
            user1.addPurchased(book2);
            user1.addPurchased(book3);
            user1.addPurchased(book4);
            user1.addPurchased(book24);
            userRepository.save(user1);
            System.err.println("**********************");



            User user2 = new User("Moe", "Zalat","moe@gmail.com","1234");
            user2.addPurchased(book1);
            user2.addPurchased(book2);
            user2.addPurchased(book5);
            user2.addPurchased(book6);
            user2.addPurchased(book7);
            user2.addPurchased(book8);
            user2.addPurchased(book9);
            user2.addPurchased(book32);
            user2.addPurchased(book24);
            user2.addPurchased(book16);
            user2.addPurchased(book17);
            userRepository.save(user2);

            User user3 = new User("Tooba", "Sheikh","tooba@gmail.com","1234");
            user3.addPurchased(book18);
            user3.addPurchased(book19);
            user3.addPurchased(book20);
            user3.addPurchased(book21);
            user3.addPurchased(book22);

            userRepository.save(user3);

            User user4 = new User("Zinah", "Al-Najjar","zinah@gmail.com","1234");
            user4.addPurchased(book22);
            user4.addPurchased(book21);
            user4.addPurchased(book1);
            user4.addPurchased(book2);
            user4.addPurchased(book3);

            userRepository.save(user4);

            log.info("users found with findAll():");
            log.info("-------------------------------");
            for (User users : userRepository.findAll()) {
                log.info(users.toString());
            }
            log.info("");


        };


    }


}