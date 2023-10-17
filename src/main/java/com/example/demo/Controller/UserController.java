package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Mapping.UserMapper;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserMapper userMapper;
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
//    @ModelAttribute("user")
//    public User user() {
//        return new User();
//    }

    @GetMapping("/")
    public List<User> getAll(){
        return userMapper.findAll();
    }

////    @GetMapping("/register")
////    public String registrationForm() {
////        return "register";
////    }
//
//    @RequestMapping(value="/register", method= RequestMethod.POST)
//    public String registerUser(@RequestParam("user_id") int user_id,
//                               @RequestParam("password") String password,
//                               RedirectAttributes attributes) {
//        User registeredUser = userService.registerUser(user_id, password);
//        if (registeredUser == null){
//            attributes.addFlashAttribute("error", "Registration Error, Please try again");
//            return "redirect:/register";
//        }
//        return "redirect:/login";
//    }
}
