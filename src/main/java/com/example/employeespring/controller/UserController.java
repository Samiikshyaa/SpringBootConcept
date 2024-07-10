package com.example.employeespring.controller;

import com.example.employeespring.service.UserService;
import com.example.employeespring.view.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getIndex() {
        return "Index";
    }

    @GetMapping("/signup")
    public String getSignUp() {
        return "SignupForm";
    }

    @PostMapping("/signup")
    public String postSignUp(@ModelAttribute User user) {
        user.setRole("Admin");
        userService.signup(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "LoginForm";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute User user, Model model){
        User u = userService.login(user.getEmail(), user.getPassword());
        if(u!=null){
            model.addAttribute("fname",u.getFname());
            return "Home";
        }
        model.addAttribute("error","User not found!");
        return "LoginForm";
    }
    @GetMapping("/home")
    public String gethome(@ModelAttribute User user, Model model){
        User u = userService.login(user.getEmail(), user.getPassword());
        model.addAttribute("fname",user.getFname());
        return "Home";
    }
}
