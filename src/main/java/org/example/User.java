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


    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;

    }


    public User(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public User() {

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








}

