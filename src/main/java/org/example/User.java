package org.example;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long userId = null;


    public String email;
    public String password;
    private String firstName;
    private String lastName;

    private String lastSearched;


    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        System.err.println("&&&&&&&&&&1");

    }


    public User(String email, String password) {
        this.email = email;
        this.password = password;
        System.err.println("&&&&&&&&&&2");

    }

    public User() {
        System.err.println("&&&&&&&&&&3");

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }


    public Long getId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLastSearched(){
        System.err.println("getting "+ this.lastSearched);
        System.err.println("getting "+ this);
        return lastSearched;


    }

    public void setLastSearched(String lastSearched){
        this.lastSearched = lastSearched;
        System.err.println("setting "+ this.lastSearched);
        System.err.println("setting "+ this);

    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }








}

