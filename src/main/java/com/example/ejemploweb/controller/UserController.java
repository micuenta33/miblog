package com.example.ejemploweb.controller;

import com.example.ejemploweb.DTO.ChangePasswordUser;
import com.example.ejemploweb.DTO.UserDTO;
import com.example.ejemploweb.entity.Post;
import com.example.ejemploweb.entity.User;
import com.example.ejemploweb.service.PostService;
import com.example.ejemploweb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final PostService postService;

    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
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
        return "redirect:login?registered";
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
    @GetMapping("/user/posts/{id}")
    public String getPublishedPostsByUser(@PathVariable Long id, Model model) {
        try {
            User user = userService.getOneUser(id);
            List<Post> publishedPosts = postService.getPublishedPostsByUser(user);
            model.addAttribute("user", user);
            model.addAttribute("posts", publishedPosts);
            return "user_posts" ;
        } catch (Exception e) {
            // Manejo de excepciones
            model.addAttribute("error", e.getMessage());
            System.out.println(e.getStackTrace());
            return "error";
        }
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
    public String deleteUser(@RequestParam(value = "error", required = false) String error,
                             @PathVariable Long id, Model model, HttpServletRequest request ){

            userService.deleteUser(id);
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
        return "redirect:/";
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
