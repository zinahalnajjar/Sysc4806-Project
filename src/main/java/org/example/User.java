package org.example;

import jakarta.persistence.*;

import java.util.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long userId;

    private int cartTotal = 0;

    public String email;
    public String password;
    private String firstName;
    private String lastName;

    private boolean current = false;

    @ManyToMany
    private List<Book> purchased;

    @ManyToMany
    private List<Book> inCart;

    private boolean owner;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.owner = false;
        purchased = new ArrayList<>();
        inCart = new ArrayList<>();
    }


    public User(String email, String password) {
        this.email = email;
        this.password = password;
        purchased = new ArrayList<Book>();
        inCart = new ArrayList<Book>();
        this.owner = false;
    }

    public User() {
        purchased = new ArrayList<Book>();
        inCart = new ArrayList<Book>();
        this.owner = false;
    }


    public String getEmail() {
        return email;
    }


    public Long getId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }



    public String getPassword() {
        return password;
    }


    public List<Book> getPurchased() {
        return purchased;
    }

    public void addPurchased(Book book) {
        this.purchased.add(book);
    }

    public void removePurchased(Book book) {

        this.purchased.remove(book);
    }


    public List<Book> getInCart() {
        return inCart;
    }

    public void removeInCart(Book book) {

        this.inCart.remove(book);
    }
    public List<Book>  resetCart(){

        return inCart = new ArrayList<>();

    }

    public void addInCart(Book book) {
        this.inCart.add(book);
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public boolean getRole() {
        return owner;
    }

    public void setRole(boolean owner) {
        this.owner = owner;
    }

    public void setCartTotal(int cartTotal) {
        this.cartTotal = cartTotal;
    }

    public int getCartTotal() {

        for(Book b : inCart){
            cartTotal += b.getPrice();
        }

        return cartTotal;
    }

}

