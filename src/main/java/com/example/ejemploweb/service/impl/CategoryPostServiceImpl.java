package com.example.ejemploweb.service.impl;

import com.example.ejemploweb.entity.CategoryPost;
import com.example.ejemploweb.repository.CategoryPostRepository;
import com.example.ejemploweb.service.CategoryPostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryPostServiceImpl implements CategoryPostService {

    private final CategoryPostRepository categoryPostRepository;

    public CategoryPostServiceImpl(CategoryPostRepository categoryPostRepository) {
        this.categoryPostRepository = categoryPostRepository;
    }

    @Override
    public List<CategoryPost> getAllCategoryPost() {
        return categoryPostRepository.findAll() ;
    }

    @Override
    public CategoryPost getCategoryById(Long id) {
        return categoryPostRepository.findById(id).get();
    }
}
