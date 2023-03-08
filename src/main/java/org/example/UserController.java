package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    private ArrayList<String> sortOptions;

    /*
    @ModelAttribute
    public void loadOptions(Model model) {
        sortOptions = new ArrayList<>();
        sortOptions.add("Price high to low");
        sortOptions.add("Sort by author");
        // rest of sorting options -->tooba

    }

     */

    @GetMapping("/start")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("loginuser", user);
        //model.addAttribute("error",1);
        return "login";
    }


    @GetMapping("/")
    public String signUp(Model model) {
        User user = new User();
        model.addAttribute("signupUser", user);
        return "signup";
    }

/*
    @GetMapping("/all")
    public String home(Model model) {
        Sort sort = new Sort();
        model.addAttribute("sortOptions", sort);
        return "search";
    }

 */

    /*
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String displaysort(Model model) {
        model.addAttribute("sortOptions", new Sort());
        return "search";
    }
*/



    @PostMapping("/userLogin")
    public String loginUser(@ModelAttribute("loginuser") User user, @RequestParam(value = "email") String email, @RequestParam(value = "password") String password, Model model) {
        //long userId = user.getId();
        User userdata = this.userRepository.findByEmail(email);
        if (password.equals(userdata.getPassword())) {
            //model.addAttribute("displayedbooks", bookRepository.findAll());
            //model.addAttribute("displayedbooks",bookRepository.findByOrderByCostAsc());
            model.addAttribute("displayedbooks", bookRepository.findByOrderByAuthorAsc());
            return "search";
        } else {
            model.addAttribute("error", 1);
            return "login";
        }

    }


/*
    @PostMapping("/sortallbooks")
    public String sortBooks(@ModelAttribute("sortOptions") Sort sort, @RequestParam(value = "options") String options, Model model) {
        if (options.equals("1")) {
            model.addAttribute("displayedbooks", bookRepository.findByOrderByCostDesc());
            return "search";

        } else if (options.equals("2")) {
            model.addAttribute("displayedbooks", bookRepository.findByOrderByAuthorAsc());
            return "search";

        }
        return "search";
    }

*/


    @PostMapping("/userSignup")
    public String signupUser(@ModelAttribute("signupUser") User user, @RequestParam(value = "email") String email,  @RequestParam(value = "password") String password,
                             @RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName, Model model){
        User signedUser = new User(firstName, lastName ,email, password);
        userRepository.save(signedUser);
        model.addAttribute("displayedbooks", bookRepository.findAll());

        return "search";

    }



}
