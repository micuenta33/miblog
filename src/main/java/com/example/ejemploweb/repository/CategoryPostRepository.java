package com.example.ejemploweb.repository;

import com.example.ejemploweb.entity.CategoryPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryPostRepository extends JpaRepository<CategoryPost,Long> {
}
