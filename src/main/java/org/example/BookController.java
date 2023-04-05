package org.example;

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

        Sort sort = new Sort();
        model.addAttribute("sortOptions", sort);
        model.addAttribute("searchWord", br.findAll());

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
        model.addAttribute("searchWord", br.findAll());

        return "search";
    }

    @GetMapping("/account")
    public String displayAccount(Model model) {
        ArrayList<User> users = (ArrayList<User>) ur.findAll();
        Recommendation r = new Recommendation(users);
        model.addAttribute("user", r.getCurrentUser());
        return "account";
    }

    @GetMapping("/recommendation")
    public String displayRecommendation(Model model) {
        ArrayList<User> users = (ArrayList<User>) ur.findAll();
        Recommendation r = new Recommendation(users);

        r.findRecommendations();

        ArrayList<Book> books = r.getRecommendations();
        model.addAttribute("displayedbooks", books);

        return "recommendation";
    }


    @PostMapping("/search/sortallbooks")
    public String sortBooks(@ModelAttribute("sortOptions") Sort sort, @RequestParam(value = "options") String options, Model model) {

        Sort sort1 = new Sort();
        model.addAttribute("sortOptions", sort1);

        if (options.equals("1")) {
            ArrayList<Book> books = (ArrayList<Book>) br.findByOrderByPriceDesc();
            model.addAttribute("displayedbooks", books);
            return "search";

        } else if (options.equals("2")) {
            ArrayList<Book> books = (ArrayList<Book>) br.findByOrderByAuthorAsc();
            model.addAttribute("displayedbooks", books);
            return "search";
        }else if (options.equals("3")){
            ArrayList<Book> books = (ArrayList<Book>) br.findByOrderByPriceAsc();
            model.addAttribute("displayedbooks", books);
            return "search";

        }else if (options.equals("4")){
            ArrayList<Book> books = (ArrayList<Book>) br.findByOrderByTitleAsc();
            model.addAttribute("displayedbooks", books);
            return "search";
        }

        return "search";
    }

    @PostMapping("/SearchBar")
    public String searchBar(@ModelAttribute("searchWord") Book book, Model model, @RequestParam(value = "searchInput") String searchInput) {

        ArrayList<Book> books = (ArrayList<Book>) br.findBySearchAllIgnoreCaseContainingOrderByTitleAsc(searchInput);

        Sort sort = new Sort();
        model.addAttribute("sortOptions", sort);
        model.addAttribute("displayedbooks", books);

        return "search";
    }
}