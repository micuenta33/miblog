package com.example.ejemploweb.controller;

import com.example.ejemploweb.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;
    @GetMapping("/contact")
    public String getContact(){
        return "contacto";
    }

}
