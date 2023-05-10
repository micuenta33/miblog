package com.example.ejemploweb.service.impl;

import com.example.ejemploweb.DTO.PostDTO;
import com.example.ejemploweb.DTO.mapper.impl.PostInDtoToPost;
import com.example.ejemploweb.entity.Post;
import com.example.ejemploweb.repository.PostRepository;
import com.example.ejemploweb.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {

    private  final PostRepository postRepository;
    private final PostInDtoToPost postInDtoToPost;

    public PostServiceImpl(PostRepository postRepository, PostInDtoToPost postInDtoToPost) {
        this.postRepository = postRepository;
        this.postInDtoToPost = postInDtoToPost;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public void addPost(PostDTO postDTO) {
        Post post= postInDtoToPost.map(postDTO);
        postRepository.save(post);
    }
}
