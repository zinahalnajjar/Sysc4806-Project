package org.example;

import org.example.enums.Age;
import org.example.enums.Genre;
import org.example.enums.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository br;

    @Autowired
    private UserRepository ur;

    @GetMapping("/bookdetails/{id}")
    public String displayBookDetails(@PathVariable("id") long id, Model model) {
        Book b = br.findById(id);
        model.addAttribute("book", b);

        return "details";
    }

    @GetMapping("/cart")
    public String displayCart() {
        return "cart";
    }

    @PostMapping("/cart")
    public String addToCart() {
        return "cart";
    }

    @GetMapping("/search")
    public String displaySearch(Model model) {
        List<String> values = new ArrayList<String>();
        model.addAttribute("displayedbooks", br.findAll());

        return "search";
    }

    @RequestMapping("/search/filter")
    public String displayFilteredResults(Model model, @RequestParam("filter_input") ArrayList<String> values) throws InterruptedException {
        ArrayList<Book> books = (ArrayList<Book>) br.findAll();
        Filter f = new Filter();

        if(values.size() > 0){
            for (String a : values){
                if(a.equals(String.valueOf(Age.G))){
                    books = f.filterAge(books, Age.G);
                    if(books.size() == 1 &&  books.get(0).getId() == -1L){
                       return "search";
                    }
                }
                if(a.equals(String.valueOf(Age.PG))){
                    books = f.filterAge(books, Age.PG);
                    if(books.size() == 1 &&  books.get(0).getId() == -1L){
                        return "search";
                    }
                }
                if(a.equals(String.valueOf(Age.PG_13))){
                    books = f.filterAge(books, Age.PG_13);
                    if(books.size() == 1 &&  books.get(0).getId() == -1L){
                        return "search";
                    }
                }
                if(a.equals(String.valueOf(Age.R))){
                    books = f.filterAge(books, Age.R);
                    if(books.size() == 1 &&  books.get(0).getId() == -1L){
                        return "search";
                    }
                }

                if(a.equals(String.valueOf(Genre.ROMANCE))){
                    books = f.filterGenre(books, Genre.ROMANCE);
                    if(books.size() == 1 &&  books.get(0).getId() == -1L){
                        return "search";
                    }
                }

                if(a.equals(String.valueOf(Genre.HISTORY))){
                    books = f.filterGenre(books, Genre.HISTORY);
                    if(books.size() == 1 &&  books.get(0).getId() == -1L){
                        return "search";
                    }
                }

                if(a.equals(String.valueOf(Genre.FANTASY))){
                    books = f.filterGenre(books, Genre.FANTASY);
                    if(books.size() == 1 &&  books.get(0).getId() == -1L){
                        return "search";
                    }
                }

                if(a.equals(String.valueOf(Genre.FICTION))){
                    books = f.filterGenre(books, Genre.FICTION);
                    if(books.size() == 1 &&  books.get(0).getId() == -1L){
                        return "search";
                    }
                }

                if(a.equals(String.valueOf(Language.ENGLISH))){
                    books = f.filterLanguage(books, Language.ENGLISH);
                    if(books.size() == 1 &&  books.get(0).getId() == -1L){
                        return "search";
                    }
                }

                if(a.equals(String.valueOf(Language.FRENCH))){
                    books = f.filterLanguage(books, Language.FRENCH);
                    if(books.size() == 1 &&  books.get(0).getId() == -1L){
                        return "search";
                    }

                }

                if(a.equals("Under 10")){
                    books = f.filterPrice(books, 10, 0);
                    if(books.size() == 1 &&  books.get(0).getId() == -1L){
                        return "search";
                    }
                }

                if(a.equals("10 - 50")){
                    books = f.filterPrice(books, 50, 10);
                    if(books.size() == 1 &&  books.get(0).getId() == -1L){
                        return "search";
                    }
                }

                if(a.equals("50 - 100")){
                    books = f.filterPrice(books, 100, 50);
                    if(books.size() == 1 &&  books.get(0).getId() == -1L){
                        return "search";
                    }
                }

                if(a.equals("Over 100")){
                    books = f.filterPrice(books, 100000, 100);
                    if(books.size() == 1 &&  books.get(0).getId() == -1L){
                        return "search";
                    }
                }

            }
        }

        model.addAttribute("displayedbooks", books);

        return "search";
    }



    @GetMapping("/account")
    public String displayAccount(Model model) {
        User user = ur.findByEmail("sam.bauer@gmail.com");
        model.addAttribute("user", user);

        return "account";
    }

    @GetMapping("/recommendation")
    public String displayRecommendation() {
        return "recommendation";
    }

}