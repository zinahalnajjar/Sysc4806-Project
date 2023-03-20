package org.example;

import org.example.enums.*;

import java.util.ArrayList;

public class Filter {


    public Filter() {
    }

    public ArrayList<Book> filterAge(ArrayList<Book> books, Age age){
        ArrayList<Book> filteredList = new ArrayList<>();
        for(Book b : books){
            if(b.getGenre().equals(age)){
                filteredList.add(b);
            }
        }
        if(filteredList.isEmpty()){
            filteredList.add(new Book(-1L));
            return filteredList;
        }

        return filteredList;
    }

    public ArrayList<Book> filterLanguage(ArrayList<Book> books, Language lang){
        ArrayList<Book> filteredList = new ArrayList<>();
        for(Book b : books){
            if(b.getGenre().equals(lang)){
                filteredList.add(b);
            }
        }
        if(filteredList.isEmpty()){
            filteredList.add(new Book(-1L));
            return filteredList;
        }

        return filteredList;
    }

    public ArrayList<Book> filterGenre(ArrayList<Book> books, Genre genre){
        ArrayList<Book> filteredList = new ArrayList<>();
        for(Book b : books){
            if(b.getGenre().equals(genre)){
                filteredList.add(b);
            }
        }
        if(filteredList.isEmpty()){
            filteredList.add(new Book(-1L));
            return filteredList;
        }

        return filteredList;
    }

    public ArrayList<Book> filterPrice(ArrayList<Book> books, int upper, int lower) throws InterruptedException {
        ArrayList<Book> filteredList = new ArrayList<>();
        for(Book b : books){
            if(b.getPrice() < upper && b.getPrice() > lower){
                filteredList.add(b);

            }
        }

        if(filteredList.isEmpty()){
            filteredList.add(new Book(-1L));
            return filteredList;
        }

        return filteredList;
    }
}
