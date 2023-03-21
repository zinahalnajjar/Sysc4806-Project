package org.example;

import org.example.enums.*;

import java.util.ArrayList;

public class Filter {

    ArrayList<Book> books;
    ArrayList<Book> filteredList;

    public Filter(ArrayList<Book> books) {
        this.books = books;
        filteredList = new ArrayList<>();
    }

    public  void filterBooks(ArrayList<String> filters){
        for (String a : filters){
            System.out.println(a);

            if(a.equals("PG_13") || a.equals("G") || a.equals("PG") || a.equals("R")){
                filterAge(a);
            }else if(a.equals("FICTION") || a.equals("FANTASY") || a.equals("HORROR")|| a.equals("YOUNG_ADULT") || a.equals("ROMANCE") || a.equals("HISTORY") || a.equals("KIDS")){
                filterGenre(a);
            }else if(a.equals("ENGLISH") || a.equals("FRENCH")){
                filterLanguage(a);
            }
            else{
                if(a.equals("Under 10")){
                    filterPrice(10, 0);
                }

                if(a.equals("10 - 50")){
                    filterPrice(50, 10);
                }

                if(a.equals("50 - 100")){
                    filterPrice(100, 50);
                }

                if(a.equals("Over 100")){
                    filterPrice(100000, 100);
                }
            }

            if(books.size() == 0){
                books.add(new Book(-1L));
            }
        }
    }
    public void filterAge(String age){
        for(Book b : books){
            if(age.equals(String.valueOf(b.getAge()))){
                filteredList.add(b);
                System.out.println(b.getTitle());
            }
        }

        books = filteredList;
        filteredList = new ArrayList<>();
    }

    public void filterGenre(String genre){
        for(Book b : books){
            if(genre.equals(String.valueOf(b.getGenre()))){
                filteredList.add(b);
                System.out.println(b.getTitle());
            }
        }

        books = filteredList;
        filteredList = new ArrayList<>();
    }

    public void filterLanguage(String lang){
        for(Book b : books){
            if(lang.equals(String.valueOf(b.getLanguage()))){
                filteredList.add(b);
                System.out.println(b.getTitle());
            }
        }
        books = filteredList;
        filteredList = new ArrayList<>();
    }

    public void filterPrice(int upper, int lower){
        for(Book b : books){
            if(b.getPrice() <= upper && b.getPrice() >= lower){
                filteredList.add(b);
                System.out.println(b.getTitle());

            }
        }
        books = filteredList;
        filteredList = new ArrayList<>();

    }

    public ArrayList<Book> getFilteredList() {
        return books;
    }
}
