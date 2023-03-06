package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/start")
    public String login(Model model){
        User user=new User();
        model.addAttribute("loginuser",user);
        return "login";
    }


    @GetMapping("/")
    public String signUp(Model model){
        User user=new User();
        model.addAttribute("signupUser",user);
        return "signup";
    }


    @PostMapping("/userLogin")
    public String loginUser(@ModelAttribute("loginuser") User user, @RequestParam(value = "email") String email,  @RequestParam(value = "password") String password) {
        //long userId = user.getId();
        User userdata = this.userRepository.findByEmail(email);
        if (password.equals(userdata.getPassword())) {
            return "search";
        }else{
            return "error";
        }

    }

    @PostMapping("/userSignup")
    public String signupUser(@ModelAttribute("signupUser") User user, @RequestParam(value = "email") String email,  @RequestParam(value = "password") String password,
                             @RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName){
        User signedUser = new User(firstName, lastName ,email, password);
        userRepository.save(signedUser);

        return "search";

    }



}
