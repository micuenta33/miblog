package com.example.ejemploweb.controller;

import com.example.ejemploweb.entity.User;
import com.example.ejemploweb.service.UserService;
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
    public String getindex(Model model) {
        return "sesion";
    }
    @GetMapping("/registro")
    public String getRegistro(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "registro";
    }
    @PostMapping("/registro")
    public String getRegistro(@ModelAttribute("user") User user) {
             userService.createUser(user);
        return "redirect:/";
    }
}
