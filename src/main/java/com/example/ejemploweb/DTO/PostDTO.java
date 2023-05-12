package com.example.ejemploweb.DTO;

import com.example.ejemploweb.entity.CategoryPost;
import lombok.Data;

@Data
public class PostDTO {
    private String title;
    private String urlImg;
    private String description;
    private CategoryPost categoryPost;
}
