package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String login(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "login";
    }

    @PostMapping("/userLogin")
    public String loginUser(@ModelAttribute("user") User user) {
        long userId = user.getId();
        User userData = userRepository.findByID(userId);
        if (user.getPassword().equals(userData.getPassword())) {
            return "search";
        }else{
            return "error";
        }
    }

}
