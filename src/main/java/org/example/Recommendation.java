package org.example;

import java.util.ArrayList;
import java.util.List;

public class Recommendation {
    ArrayList<User> users;
    List<Book> set1 = new ArrayList<>();
    List<Book> set2 = new ArrayList<>();

    User currentUser;
    ArrayList<Book> recommendations = new ArrayList<>();

    public Recommendation(ArrayList<User> users) {
        this.users = users;

        for(User user : users){
            if(user.isCurrent()){
                this.currentUser= user;
            }
        }

    }

    public void findRecommendations(){
        set1 = currentUser.getPurchased();
        for(User user : users){
            if(user != currentUser){
                set2 = user.getPurchased();
                if(checkSimilar()){
                    findUnique();
                    removeDuplicates();
                }
            }

        }
    }

    private void removeDuplicates() {
        ArrayList<Book> temp = new ArrayList<>();

        for (Book b : recommendations) {
            if (!temp.contains(b)) {
                temp.add(b);
            }
        }

        recommendations = temp;
    }

    private boolean checkSimilar(){
        for (Book b : set1) {
            for (Book b2 : set2) {
                if (b == b2) {
                    return true;
                }
            }
        }
        return false;
    }

    private void findUnique(){
        for (Book b : set1) {
            for (Book b2 : set2) {
                if (b != b2) {
                    recommendations.add(b2);
                }
            }
        }
    }

    public ArrayList<Book> getRecommendations() {
        return recommendations;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
