package com.example.ejemploweb.controller;

import com.example.ejemploweb.DTO.ContactDTO;

import com.example.ejemploweb.entity.User;
import com.example.ejemploweb.repository.UserRepository;
import com.example.ejemploweb.service.ContactService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {
    private final ContactService contactService;
    private final UserRepository userRepository;

    public ContactController(ContactService contactService, UserRepository userRepository) {
        this.contactService = contactService;
        this.userRepository = userRepository;
    }

    @GetMapping("/contact")
    public String getContact(Model model) {
        ContactDTO contactDTO = new ContactDTO();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!auth.getPrincipal().equals("anonymousUser")){
            User user = userRepository.findByUserName(auth.getName()).get();
            model.addAttribute("user", user);
            contactDTO.setEmail(user.getEmail());
            contactDTO.setName(user.getLastName()+" "+user.getFirstName());
        }
        model.addAttribute("contactDTO", contactDTO);
        return "contact/contact";
    }
    @PostMapping("/contact")
    public String Contact(@ModelAttribute("contact") ContactDTO contactDTO, Model model) {
        contactService.saveContact(contactDTO);
        return "redirect:/posts";
    }

}
