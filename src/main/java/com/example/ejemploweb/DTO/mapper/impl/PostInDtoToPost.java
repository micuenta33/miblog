package com.example.ejemploweb.DTO.mapper.impl;

import com.example.ejemploweb.DTO.PostDTO;
import com.example.ejemploweb.DTO.mapper.IMapper;
import com.example.ejemploweb.entity.Post;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class PostInDtoToPost implements IMapper<PostDTO, Post> {
    @Override
    public Post map(PostDTO in) {
        Post post = new Post();
        post.setTitle(in.getTitle());
        post.setDescription(in.getDescription());
        post.setUrlImg(in.getUrlImg());
        post.setUser(in.getUser());
        post.setCategory(in.getCategoryPost());
        post.setCreatedDate(LocalDate.now());
        return post;
    }
}
