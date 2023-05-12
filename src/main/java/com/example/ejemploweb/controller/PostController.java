package com.example.ejemploweb.controller;

import com.example.ejemploweb.DTO.PostDTO;
import com.example.ejemploweb.entity.CategoryPost;
import com.example.ejemploweb.entity.Post;
import com.example.ejemploweb.service.CategoryPostService;
import com.example.ejemploweb.service.PostService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostService postService;
    private final CategoryPostService categoryPostService;

    public PostController(PostService postService, CategoryPostService categoryPostService) {
        this.postService = postService;
        this.categoryPostService = categoryPostService;
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
        PostDTO post = new PostDTO();
        model.addAttribute("post",post);
        model.addAttribute("categories",categoryPostService.getAllCategoryPost());
        return "add";
    }
    @PostMapping("/posts/add")
    public String addNewPost(@ModelAttribute("post") PostDTO postDTO,@RequestParam("category") Long categoryId){
        CategoryPost categoryPost=categoryPostService.getCategoryById(categoryId);
        postDTO.setCategoryPost(categoryPost);
        postService.addPost(postDTO);
        return "redirect:/posts";
    }
}
