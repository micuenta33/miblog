package com.example.ejemploweb.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordUser {
    private Long id;

    private String CurrentPassword;

    private String newPassword;

    private String confirmPassword;

    public ChangePasswordUser(Long id) {
        this.id = id;
    }
}
