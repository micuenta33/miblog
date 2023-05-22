package com.example.ejemploweb.DTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ContactDTO {
    private String name;
    private String email;
    private String subject;
    private String message;
}
