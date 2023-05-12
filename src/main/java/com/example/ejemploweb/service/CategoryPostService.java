package com.example.ejemploweb.service;

import com.example.ejemploweb.entity.CategoryPost;

import java.util.List;

public interface CategoryPostService{
    List<CategoryPost> getAllCategoryPost();
    CategoryPost getCategoryById(Long id);
}
