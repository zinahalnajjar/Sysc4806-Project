package org.example;

import jakarta.persistence.*;
import org.example.enums.Age;
import org.example.enums.Genre;
import org.example.enums.Language;


@Entity
public class Book {
    private String title;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int ISBN;
    private String author;
    private String publisher;
    private String description;
    private String picture;
    private Language language;
    private Genre genre;
    private Age age;
    private int inventory;
    private double price;

    public Book(Long Id, String title, int ISBN, String author, String publisher, String description, String picture, int inventory, double cost, Language language, Genre genre, Age age) {
        this.id = id;
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.publisher = publisher;
        this.description = description;
        this.picture = picture;
        this.inventory = inventory;
        this.price = cost;
        this.age = age;
        this.language = language;
        this.genre = genre;
    }

    public Book() {

    }

    public Book(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float cost) {
        this.price = cost;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
