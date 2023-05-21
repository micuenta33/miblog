package com.example.ejemploweb.repository;


import com.example.ejemploweb.entity.Post;
import com.example.ejemploweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUser(User user);

}
