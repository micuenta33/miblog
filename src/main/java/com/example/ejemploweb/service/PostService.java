package com.example.ejemploweb.service;

import com.example.ejemploweb.DTO.PostDTO;
import com.example.ejemploweb.entity.Post;
import com.example.ejemploweb.entity.User;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPosts();
    List<Post> getPublishedPostsByUser(User user) ;
    Post getPostById(Long id);
    void addPost(PostDTO postDTO);
}
