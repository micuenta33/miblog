package com.example.ejemploweb.controller;

import com.example.ejemploweb.DTO.PostDTO;
import com.example.ejemploweb.entity.CategoryPost;
import com.example.ejemploweb.entity.Post;
import com.example.ejemploweb.entity.User;
import com.example.ejemploweb.repository.UserRepository;
import com.example.ejemploweb.service.CategoryPostService;
import com.example.ejemploweb.service.PostService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class PostController {

    private final PostService postService;
    private final CategoryPostService categoryPostService;
    private final UserRepository userRepository;

    public PostController(PostService postService, CategoryPostService categoryPostService, UserRepository userRepository) {
        this.postService = postService;
        this.categoryPostService = categoryPostService;
        this.userRepository = userRepository;
    }

    @GetMapping(value = {"/posts", "/"})
    public String getAllPosts(Model model) {
        List<Post> listaPosts = postService.getAllPosts();
        model.addAttribute("listPosts", listaPosts);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println();
        if(!auth.getPrincipal().equals("anonymousUser")){
            User user = userRepository.findByUserName(auth.getName()).get();
            model.addAttribute("user", user);
        }
        return "index";
    }

    @GetMapping("/posts/post/{id}")
    public String getOnePost(@PathVariable Long id, Model model) {
        model.addAttribute("onePost", postService.getPostById(id));
        return "post";
    }

    @GetMapping("/posts/add")
    public String formNwePost(Model model,Authentication auth) {
        PostDTO post = new PostDTO();
        model.addAttribute("post", post);
        model.addAttribute("categories", categoryPostService.getAllCategoryPost());
         //auth = SecurityContextHolder.getContext().getAuthentication();

        return "add";
    }

    @PostMapping("/posts/add")
    public String addNewPost(@ModelAttribute("post") PostDTO postDTO,@RequestParam("category") Long categoryId,Authentication auth) {
        if(!auth.getPrincipal().equals("anonymousUser")){
            System.out.println(auth.getPrincipal());
            User user = userRepository.findByUserName(auth.getName()).get();
            postDTO.setUser(user);
        }
        CategoryPost categoryPost = categoryPostService.getCategoryById(categoryId);
        postDTO.setCategoryPost(categoryPost);
        postService.addPost(postDTO);
        return "redirect:/posts";
    }
}

