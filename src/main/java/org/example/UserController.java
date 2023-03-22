package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

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

    @PostMapping("/userLogin")
    public String loginUser(@ModelAttribute("loginuser") User user, @RequestParam(value = "email") String email, @RequestParam(value = "password") String password, Model model) {
        User userdata = this.userRepository.findByEmail(email);

        model.addAttribute("user", userdata);

        if (password.equals(userdata.getPassword())) {
            userdata.setCurrent(true);
            userRepository.save(userdata);

            ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
            Recommendation r = new Recommendation(users);
            r.findRecommendations();
            ArrayList<Book> rec = r.getRecommendations();

            model.addAttribute("displayedbooks", rec);

            return "recommendation";
        } else {
            model.addAttribute("error", 1);
            return "login";
        }
    }


    @PostMapping("/userSignup")
    public String signupUser(@ModelAttribute("signupUser") User user, @RequestParam(value = "email") String email,  @RequestParam(value = "password") String password,
                             @RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName, Model model){
        User signedUser = new User(firstName, lastName ,email, password);
        signedUser.setCurrent(true);
        userRepository.save(signedUser);

        ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
        Recommendation r = new Recommendation(users);
        r.findRecommendations();
        ArrayList<Book> rec = r.getRecommendations();

        model.addAttribute("displayedbooks", rec);

        return "recommendation";
    }
}
