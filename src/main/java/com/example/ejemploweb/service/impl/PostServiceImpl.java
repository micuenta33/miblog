package com.example.ejemploweb.service.impl;

import com.example.ejemploweb.DTO.PostDTO;
import com.example.ejemploweb.DTO.mapper.impl.PostInDtoToPost;
import com.example.ejemploweb.entity.Post;
import com.example.ejemploweb.entity.User;
import com.example.ejemploweb.repository.PostRepository;
import com.example.ejemploweb.repository.UserRepository;
import com.example.ejemploweb.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private  final PostRepository postRepository;
    private final PostInDtoToPost postInDtoToPost;
    private final UserRepository userRepository;


    public PostServiceImpl(PostRepository postRepository, PostInDtoToPost postInDtoToPost, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.postInDtoToPost = postInDtoToPost;
        this.userRepository = userRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getPublishedPostsByUser(User user) {
        return postRepository.findByUser(user);
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
