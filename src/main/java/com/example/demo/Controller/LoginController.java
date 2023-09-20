package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Mapping.UserMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.example.demo.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model,
                        @RequestParam("user_id") int user_id,
                        @RequestParam("password") String password){
        User user = userService.authenticate(user_id,password);
        if(user != null){
            request.getSession().setAttribute("logged_in_user", user);
            // by adding to session, the user can be later removed to logout
            return "redirect:/home"; // to user home page
        }else{
            model.addAttribute("error","Invalid user_id or password");
            return "login"; // back to login page
        }

    }

    @RequestMapping(value = "/logout", method= RequestMethod.GET)
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
            // remove the user from the session
        }
        return "redirect:/login";
    }

}
