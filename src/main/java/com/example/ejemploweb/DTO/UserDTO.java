package com.example.ejemploweb.DTO;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private String userName;
    private String lastName;
    private String firstName;
    private String password;
    private String confirmPassword;
    private List<String> roles;
    private String email;
}

