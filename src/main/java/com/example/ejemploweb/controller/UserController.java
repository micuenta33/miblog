package com.example.ejemploweb.controller;

import com.example.ejemploweb.DTO.ChangePasswordUser;
import com.example.ejemploweb.DTO.UserDTO;
import com.example.ejemploweb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        UserDTO user = new UserDTO();
        model.addAttribute("user",user);
        return "register";
    }
    @PostMapping("/registro")
    public String register(@ModelAttribute("user") UserDTO userDTO,Model model) {
        try {
            userService.createUser(userDTO);
        } catch (Exception e) {
            model.addAttribute("errorMessage",e.getMessage());
            return "register";
        }
        return "redirect:/";
    }
    @GetMapping("/user/{id}")
    public String getOneUser(@PathVariable Long id, Model model) {
        try {
            model.addAttribute("oneUser",userService.getOneUser(id));
        } catch (Exception e) {
            model.addAttribute("errorMessage",e.getMessage());
        }
        return "profile";
    }

    @GetMapping("/user/edit/{id}")
    public String getOneUserEdit(@PathVariable Long id, Model model) {
        try {
            model.addAttribute("oneUser",userService.getOneUser(id));
        } catch (Exception e) {
            model.addAttribute("errorMessage",e.getMessage());
        }
        return "edit";
    }
    @PostMapping("/user/edit/{id}")
    public String OneUserEdit(@PathVariable Long id,@ModelAttribute UserDTO userDTO,Model model)  {
        try {
            userService.updateOneUser(id,userDTO);
        } catch (Exception e) {
            model.addAttribute("errorMessage",e.getMessage());
        }
        return "redirect:/user/{id}";
    }
    @GetMapping("user/delete/{id}")
    public String deleteUser(@PathVariable Long id,Model model , RedirectAttributes redirectAttributes){
        try {
            userService.deleteUser(id);
            redirectAttributes.addFlashAttribute("message", "El usuario ha sido eliminado correctamente");        } catch (Exception e) {
        }
        return getindex(model);
    }
    @GetMapping("/user/changepassworduser/{id}")
    public String changePasswordUserform(@PathVariable Long id, Model model ){
        ChangePasswordUser changePasswordUser=new ChangePasswordUser(id);
        model.addAttribute("changePasswordUser",changePasswordUser);
        return "changepassworduser";
    }
    @PostMapping("/user/changepassworduser/{id}")
    public String changePasswordUser(@ModelAttribute ChangePasswordUser changePasswordUser, Model model ){
        try {
            userService.changePassword(changePasswordUser);
        } catch (Exception e) {
            model.addAttribute("changePasswordError",e.getMessage());
        }
        return "changepassworduser";
    }


}
