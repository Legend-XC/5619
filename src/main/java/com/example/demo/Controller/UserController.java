package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Mapping.UserMapper;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/")
    public List<User> getAll(){
        return userMapper.findAll();
    }

    @PostMapping("/register")
    public String register(@RequestParam("user_id") int user_id,
                           @RequestParam("password") String password, Model model){
        User registeredUser = userService.registerUser(user_id, password);
        if(registeredUser == null){
            model.addAttribute("error","Registration failed");
            return "register";
        }
        model.addAttribute("message","Registration succeed");
        return "login";
    }
}
