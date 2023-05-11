package com.example.ejemploweb.controller;

import com.example.ejemploweb.DTO.PostDTO;
import com.example.ejemploweb.entity.Post;
import com.example.ejemploweb.service.PostService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {

    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        List<Post> listaPosts = postService.getAllPosts();
        model.addAttribute("listPosts",listaPosts);
        return "index" ;
    }
    @GetMapping("/posts/post/{id}")
    public String getOnePost(@PathVariable Long id, Model model) {
        model.addAttribute("onePost",postService.getPostById(id));
        return "post";
    }
    @GetMapping("/posts/add")
    public String formNwePost(Model model){
        Post post = new Post();
        model.addAttribute("post",post);
        return "add";
    }
    @PostMapping("/posts/add")
    public String addNewPost(@ModelAttribute("post") PostDTO postDTO){
        postService.addPost(postDTO);
        return "redirect:/posts";
    }
}
