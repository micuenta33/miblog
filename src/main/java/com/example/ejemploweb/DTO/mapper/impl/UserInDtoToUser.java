package com.example.ejemploweb.DTO.mapper.impl;

import com.example.ejemploweb.DTO.UserDTO;
import com.example.ejemploweb.DTO.mapper.IMapper;
import com.example.ejemploweb.entity.Role;
import com.example.ejemploweb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;

@Component
public class UserInDtoToUser implements IMapper<UserDTO, User> {
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserInDtoToUser(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User map(UserDTO in) {
        User user=new User();
        user.setUserName(in.getUserName());
        user.setLastName(in.getLastName());
        user.setFirstName(in.getFirstName());
        user.setPassword(passwordEncoder.encode(in.getPassword()));
        user.setEmail(in.getEmail());
        Role userRole = new Role();
        userRole.setName("user");
        user.setRoles(Collections.singletonList(userRole));
        user.setRegisterDate(LocalDate.now());
        return user;
    }
}
