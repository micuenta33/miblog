package com.example.ejemploweb.service.impl;

import com.example.ejemploweb.DTO.UserDTO;
import com.example.ejemploweb.DTO.mapper.impl.UserInDtoToUser;
import com.example.ejemploweb.entity.User;
import com.example.ejemploweb.repository.UserRepository;
import com.example.ejemploweb.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserInDtoToUser userInDtoToUser;


    public UserServiceImpl(UserRepository userRepository, UserInDtoToUser userInDtoToUser) {
        this.userRepository = userRepository;
        this.userInDtoToUser = userInDtoToUser;
    }

    private boolean checkExistEmail(UserDTO userDTO) throws Exception {
        User user = userInDtoToUser.map(userDTO);
        Optional<User> exist  = userRepository.findByEmailOrUserName(user.getEmail(),user.getUserName());
        if(exist.isPresent()){
            throw new Exception("EL email o el usuario ya existe ");
        }
        return true;
    }
    private boolean checkPassword(UserDTO userDTO) throws Exception {
        if(!userDTO.getPassword().equals(userDTO.getConfirmPassword())){
            throw new Exception("Las contraseñas no coinciden");
        }
        return true;
    }
    @Override
    public User createUser(UserDTO userDTO) throws Exception {
        User user = userInDtoToUser.map(userDTO);
        if(checkExistEmail(userDTO) && checkPassword(userDTO)){
           user= userRepository.save(user);
        }
        return user;
    }

}
