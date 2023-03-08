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

    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/start")
    public String login(Model model){
        User user=new User();
        model.addAttribute("loginuser",user);
        //model.addAttribute("error",1);
        return "login";
    }


    @GetMapping("/")
    public String signUp(Model model){
        User user=new User();
        model.addAttribute("signupUser",user);
        return "signup";
    }


    /*
    @GetMapping("/allbooks")
    public String book(Model model){
        Sort sort=new Sort();
        model.addAttribute("variableB",sort);
        //model.addAttribute("error",1);
        return "search";
    }


     */



    @PostMapping("/userLogin")
    public String loginUser(@ModelAttribute("loginuser") User user, @RequestParam(value = "email") String email,  @RequestParam(value = "password") String password, Model model) {
        //long userId = user.getId();
        User userdata = this.userRepository.findByEmail(email);
        if (password.equals(userdata.getPassword())) {
            //model.addAttribute("displayedbooks",bookRepository.findAll());
            model.addAttribute("displayedbooks",bookRepository.findByOrderByCostAsc());
            return "search";
        }else{
            model.addAttribute("error",1);
            return "login";
        }

    }

    /*
    @PostMapping("/sortall")
    public String sortBooks(@ModelAttribute("variableB") Sort sort, @RequestParam(value = "sortbooks") String sortbooks, Model model){
       // model.addAttribute("sortorder",sort1);
        //System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        //model.addAttribute("displayedbooks",bookRepository.findByOrderByCostAsc());
        return "search";
    }

     */

    // same as loging in

    // if the fiedl = 1
    // sort one way
    // the field =2
    // another way

    @PostMapping("/userSignup")
    public String signupUser(@ModelAttribute("signupUser") User user, @RequestParam(value = "email") String email,  @RequestParam(value = "password") String password,
                             @RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName){
        User signedUser = new User(firstName, lastName ,email, password);
        userRepository.save(signedUser);

        return "search";

    }



}
