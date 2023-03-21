package org.example;

import java.util.ArrayList;


public class Filter {

    boolean age = false;
    boolean lang = false;
    boolean price = false;
    boolean genre = false;

    ArrayList<Book> books;
    ArrayList<Book> filteredList;

    ArrayList<String> filters;

    public Filter(ArrayList<Book> books, ArrayList<String> filters) {
        this.books = books;
        filteredList = new ArrayList<>();
        this.filters = filters;
    }

    public  void filterBooks(){
        for (String a : filters){
            System.out.println(a);

            if(a.equals("ENGLISH") || a.equals("FRENCH")){
                if(price || age || genre){
                    books = filteredList;
                    filteredList = new ArrayList<>();
                    age = false;
                    genre = false;
                    price = false;
                }
                lang = true;
                filterLanguage(a);
            }else if(a.equals("PG_13") || a.equals("G") || a.equals("PG") || a.equals("R")){
                if(lang || price || genre){
                    books = filteredList;
                    filteredList = new ArrayList<>();
                    lang = false;
                    genre = false;
                    price = false;
                }
                age = true;
                filterAge(a);
            }else if(a.equals("FICTION") || a.equals("FANTASY") || a.equals("HORROR")|| a.equals("YOUNG_ADULT") || a.equals("ROMANCE") || a.equals("HISTORY") || a.equals("KIDS")) {
                if(lang || age || price){
                    books = filteredList;
                    filteredList = new ArrayList<>();
                    lang = false;
                    age = false;
                    price = false;
                }
                genre = true;
                filterGenre(a);
            }
            else{
                if(lang || age || genre){
                    books = filteredList;
                    filteredList = new ArrayList<>();
                    lang = false;
                    age = false;
                    genre = false;

                }
                price = true;

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
        }
    }

    public void filterLanguage(String lang){
        for(Book b : books){
            if(lang.equals(String.valueOf(b.getLanguage()))){
                filteredList.add(b);
                System.out.println(b.getTitle());
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
    }

    public void filterGenre(String genre){
        for(Book b : books){
            if(genre.equals(String.valueOf(b.getGenre()))){
                filteredList.add(b);
                System.out.println(b.getTitle());
            }
        }
    }

    public void filterPrice(int upper, int lower){
        for(Book b : books){
            if(b.getPrice() <= upper && b.getPrice() >= lower){
                filteredList.add(b);
                System.out.println(b.getTitle());

            }
        }
    }

    public ArrayList<Book> getFilteredList() {
        books = filteredList;
        return books;
    }
}
