package com.example.ejemploweb.service;

import com.example.ejemploweb.DTO.ChangePasswordUser;
import com.example.ejemploweb.DTO.UserDTO;
import com.example.ejemploweb.entity.User;
import com.example.ejemploweb.exception.user.UserNameOrIdNotFund;


public interface UserService {
     User createUser(UserDTO userDTO) throws Exception;

    User getOneUser(Long id) throws UserNameOrIdNotFund;

    User updateOneUser(Long id,UserDTO userDTO) throws Exception;

    void deleteUser(Long id) throws UserNameOrIdNotFund;
    User changePassword(ChangePasswordUser changePasswordUser) throws Exception;
}
