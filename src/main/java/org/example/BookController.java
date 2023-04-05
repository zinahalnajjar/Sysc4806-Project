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

    @PostMapping("/cart/add/{id}")
    public String addToCart(@PathVariable("id") long id, Model model) {
        Recommendation r = getRec();
        User c = r.getCurrentUser();
        Book book = br.findById(id);
        c.addInCart(book);
        ur.save(c);

        List<Book>  cart = c.getInCart();

        model.addAttribute("displayedbooks", cart);

        return "cart";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable("id") long id, Model model) {
        Recommendation r = getRec();
        User c = r.getCurrentUser();
        Book book = br.findById(id);
        c.removeInCart(book);
        ur.save(c);

        List<Book> cart = c.getInCart();

        model.addAttribute("displayedbooks", cart);

        return "cart";
    }

    @GetMapping("/checkout")
    public String displayCheckout(Model model) {
        Recommendation r = getRec();
        User c = r.getCurrentUser();
        List<Book> cart = c.getInCart();

        model.addAttribute("displayedbooks", cart);
        return "checkout";
    }



    @PostMapping ("/checkout")
    public String checkOut( Model model ) {
        Recommendation r = getRec();
        User c = r.getCurrentUser();
        //List<Book> cart = c.getInCart();
        c.resetCart();
        ur.save(c);

        return "checkout";
    }


    @GetMapping("/cart")
    public String displayCart(Model model) {
        Recommendation r = getRec();
        User c = r.getCurrentUser();

        List<Book> cart = c.getInCart();

        model.addAttribute("displayedbooks", cart);

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
        Recommendation r = getRec();
        model.addAttribute("user", r.getCurrentUser());
        return "account";
    }

    @GetMapping("/recommendation")
    public String displayRecommendation(Model model) {
        Recommendation r = getRec();
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

    private Recommendation getRec(){
        ArrayList<User> users = (ArrayList<User>) ur.findAll();
        Recommendation r = new Recommendation(users);
        return r;
    }

    @GetMapping("/addbook")
    public String displayAddBook(Model model) {
        Book b = new Book();
        model.addAttribute("book", b);

        return "addbook";
    }

    @PostMapping("/addbook")
    public String addBook(Model model, @ModelAttribute("book") Book book) {
        Book b = book;
        br.save(b);

        ArrayList<Book> books = (ArrayList<Book>) br.findAll();
        model.addAttribute("displayedbooks", books);

        return "inventory";
    }

    @GetMapping("/inventory")
    public String inventory(Model model) {
        ArrayList<Book> books = (ArrayList<Book>) br.findAll();
        model.addAttribute("displayedbooks", books);
        return "inventory";
    }

    @GetMapping("/inventory/remove/{id}")
    public String removeFromInventory(@PathVariable("id") long id, Model model) {

        br.deleteById(id);

        ArrayList<Book> books = (ArrayList<Book>) br.findAll();
        model.addAttribute("displayedbooks", books);

        return "inventory";
    }

}