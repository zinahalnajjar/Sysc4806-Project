package org.example;

import org.example.enums.Age;
import org.example.enums.Genre;
import org.example.enums.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @PostMapping("/cart")
    public String addToCart() {
        return "cart";
    }

    @GetMapping("/cart")
    public String displayCart() {
        return "cart";
    }

    @GetMapping("/search")
    public String displaySearch(Model model) {

        ArrayList<Book> books = (ArrayList<Book>) br.findAll();
        model.addAttribute("displayedbooks", books);
        return "search";
    }

    @RequestMapping("/search/filter")
    public String displayFilteredResults(Model model, @RequestParam("checkInp") ArrayList<String> inputs){

        ArrayList<Book> books = (ArrayList<Book>) br.findAll();
        Filter f = new Filter(books, inputs);

        if(!inputs.isEmpty()){
            f.filterBooks();
        }

        books = f.getFilteredList();

        model.addAttribute("displayedbooks", books);

        Sort sort = new Sort();
        model.addAttribute("sortOptions", sort);
        model.addAttribute("displayedbooks", br.findAll());
        model.addAttribute("searchWord", br.findAll());
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




    @PostMapping("/sortallbooks")
    public String sortBooks(@ModelAttribute("sortOptions") Sort sort, @RequestParam(value = "options") String options, Model model) {
        //Sort sorting = new Sort();
        //model.addAttribute("sortOptions", sorting);
        if (options.equals("1")) {
            model.addAttribute("displayedbooks", br.findByOrderByPriceDesc());
            return "search";

        } else if (options.equals("2")) {
            model.addAttribute("displayedbooks", br.findByOrderByAuthorAsc());
            return "search";
        }else if (options.equals("3")){
            model.addAttribute("displayedbooks", br.findByOrderByPriceAsc());
            return "search";

        }else if (options.equals("4")){
            model.addAttribute("displayedbooks", br.findByOrderByTitleAsc());
            return "search";
        }

        return "search";
    }


    @PostMapping("/SearchBar")
    public String searchBar(@ModelAttribute("searchWord") Book book, Model model, @RequestParam(value = "searchInput") String searchInput) {

        Sort sort = new Sort();
        model.addAttribute("sortOptions", sort);
        //Book bookinfo = this.br.findByTitle(searchInput);
        model.addAttribute("displayedbooks",br.findByAuthor(searchInput));

        return "search";
    }




}