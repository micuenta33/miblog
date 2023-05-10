package com.example.ejemploweb.service.impl;

import com.example.ejemploweb.entity.User;
import com.example.ejemploweb.repository.UserRepository;
import com.example.ejemploweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
}
