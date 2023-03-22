package org.example;

import jakarta.persistence.*;


@Entity
public class Sort {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long Id = null;


    public String options;



    public Sort(String options) {
        this.options = options;

    }

    public Sort() {

    }

    public String getOptions() {
        return options;
    }

    public Long getId() {
        return Id;
    }

}