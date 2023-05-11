package com.example.ejemploweb.service.impl;

import com.example.ejemploweb.DTO.UserDTO;
import com.example.ejemploweb.DTO.mapper.impl.UserInDtoToUser;
import com.example.ejemploweb.entity.User;
import com.example.ejemploweb.repository.UserRepository;
import com.example.ejemploweb.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserInDtoToUser userInDtoToUser;


    public UserServiceImpl(UserRepository userRepository, UserInDtoToUser userInDtoToUser) {
        this.userRepository = userRepository;
        this.userInDtoToUser = userInDtoToUser;
    }

    @Override
    public void createUser(UserDTO userDTO) {
        User user = userInDtoToUser.map(userDTO);
        userRepository.save(user);
    }
}
