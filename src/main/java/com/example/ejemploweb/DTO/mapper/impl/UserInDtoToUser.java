package com.example.ejemploweb.DTO.mapper.impl;

import com.example.ejemploweb.DTO.UserDTO;
import com.example.ejemploweb.DTO.mapper.IMapper;
import com.example.ejemploweb.entity.UserRol;
import com.example.ejemploweb.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class UserInDtoToUser implements IMapper<UserDTO, User> {
    @Override
    public User map(UserDTO in) {
        User user=new User();
        user.setUserName(in.getUserName());
        user.setLastName(in.getLastName());
        user.setFirstName(in.getFirstName());
        user.setPassword(in.getPassword());
        user.setEmail(in.getEmail());
        user.setUserRol(UserRol.USER);
        user.setRegisterDate(LocalDate.now());
        return user;
    }
}
