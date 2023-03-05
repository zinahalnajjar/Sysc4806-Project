package org.example;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private BookRepository br;
    private UserRepository ur;

    @GetMapping("/bookdetails/{id}")
    public String displayBookDetails(@PathVariable("id") int ISBN, Model model) {
        Book b = br.findById(ISBN);

        model.addAttribute("title", b.getTitle());
        model.addAttribute("author", b.getAuthor());
        model.addAttribute("publisher", b.getPublisher());
        model.addAttribute("description", b.getDescription());
        model.addAttribute("picture", b.getPicture());
        model.addAttribute("language", b.getLanguage());
        model.addAttribute("genre", b.getGenre());
        model.addAttribute("age", b.getAge());
        model.addAttribute("inventory", b.getInventory());
        model.addAttribute("price", b.getPrice());

        return "bookdetails";
    }

    @PostMapping("/bookdetails/{id}")
    public String adToCart(@PathVariable("id") int ISBN, Model model) {
        //model.addAttribute("AddressBook", new AddressBook());
        return "cart";
    }
}
