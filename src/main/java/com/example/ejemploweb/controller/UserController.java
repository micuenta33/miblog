package com.example.ejemploweb.controller;

import com.example.ejemploweb.DTO.UserDTO;
import com.example.ejemploweb.entity.User;
import com.example.ejemploweb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getindex(Model model) {
        return "sesion";
    }
    @GetMapping("/registro")
    public String getRegistro(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "register";
    }
    @PostMapping("/registro")
    public String getRegistro(@ModelAttribute("user") UserDTO userDTO) {
             userService.createUser(userDTO);
        return "redirect:/";
    }
}
