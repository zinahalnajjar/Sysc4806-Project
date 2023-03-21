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
        model.addAttribute("displayedbooks", br.findAll());
        return "search";
    }

    @RequestMapping("/search/filter")
    public String displayFilteredResults(Model model, @RequestParam("checkInp") ArrayList<String> inputs){

        ArrayList<Book> books = (ArrayList<Book>) br.findAll();
        Filter f = new Filter(books);

        if(!inputs.isEmpty()){
            f.filterBooks(inputs);
        }

        books = f.getFilteredList();

        if(books.get(0).getId() == -1L){
            return "search";
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