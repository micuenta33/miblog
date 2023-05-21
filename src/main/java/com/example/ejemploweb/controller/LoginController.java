package com.example.ejemploweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout ,Model model, Principal principal) {
        if(principal!=null){
            return "redirect:/" ;
        }
        if(error != null){
            model.addAttribute("error","Nombre de usuario o la contraseña incorrecta");
        }
        if(logout!=null){
            model.addAttribute("logout","sesion cerrada");
        }
        return "login";
    }

}
