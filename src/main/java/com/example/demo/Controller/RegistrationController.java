package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService){
        this.userService = userService;
    }

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("user") User user, RedirectAttributes attributes) {
        User registeredUser = userService.registerUser(user.getUser_id(), user.getUser_password());
        if (registeredUser == null){
            attributes.addFlashAttribute("error", "Registration Error, Please try again");
            return "redirect:/register";
        }
        return "redirect:/login";
    }
}