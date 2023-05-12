package com.example.ejemploweb.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private String userName;
    private String lastName;
    private String firstName;
    private String password;
    private String confirmPassword;
    private String email;
}

