package com.example.ejemploweb.DTO;

import com.example.ejemploweb.entity.CategoryPost;
import com.example.ejemploweb.entity.User;
import lombok.Data;

@Data
public class PostDTO {
    private String title;
    private String urlImg;
    private String description;
    private User user;
    private CategoryPost categoryPost;

}
