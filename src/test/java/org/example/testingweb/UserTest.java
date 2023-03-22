package org.example.testingweb;

import org.example.User;

import static org.junit.jupiter.api.Assertions.*;
public class UserTest {
    private User user;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.user= new User("laura", "Ma", "laura@gmail,com", "1234");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getFirstName(){
        assertEquals(user.getFirstName(),"laura");
    }
    @org.junit.jupiter.api.Test
    void setFirstName(){
        user.setFirstName("Zinah");
        assertEquals(user.getFirstName(),"Zinah");
    }
    @org.junit.jupiter.api.Test
    void getLastName(){
        assertEquals(user.getLastName(),"Ma");
    }
    @org.junit.jupiter.api.Test
    void setLastName(){
        user.setLastName("John");
        assertEquals(user.getLastName(),"John");
    }
    @org.junit.jupiter.api.Test
    void getPassword(){
        assertEquals(user.getPassword(),"1234");
    }
    @org.junit.jupiter.api.Test
    void setPassword(){
        user.setPassword("123");
        assertEquals(user.getPassword(),"123");
    }
    @org.junit.jupiter.api.Test
    void getEmail(){
        assertEquals(user.getEmail(),"laura@gmail,com");
    }
    @org.junit.jupiter.api.Test
    void setEmail(){
        user.setEmail("zinah.john@gmail.com");
        assertEquals(user.getEmail(),"zinah.john@gmail.com");
    }
}
