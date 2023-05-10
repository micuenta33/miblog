package com.example.ejemploweb.service;

import com.example.ejemploweb.DTO.PostDTO;
import com.example.ejemploweb.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Long id);
    void addPost(PostDTO postDTO);

}
