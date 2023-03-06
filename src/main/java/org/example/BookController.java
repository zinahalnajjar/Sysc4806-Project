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

        model.addAttribute("book", b);

        return "bookdetails";
    }

    @PostMapping("/bookdetails/{id}")
    public String adToCart(@PathVariable("id") int ISBN, Model model) {
        //model.addAttribute("AddressBook", new AddressBook());
        return "cart";
    }
}
