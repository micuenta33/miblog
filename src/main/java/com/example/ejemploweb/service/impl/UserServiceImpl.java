package com.example.ejemploweb.service.impl;

import com.example.ejemploweb.DTO.ChangePasswordUser;
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

    private boolean checkExistEmailAndUserName(UserDTO userDTO) throws Exception {
        User user = userInDtoToUser.map(userDTO);
        Optional<User> exist  = userRepository.findByEmailOrUserName(user.getEmail(),user.getUserName());
        if(exist.isPresent()){
            throw new Exception("EL email o el nombre usuario ya existe ");
        }
        return true;
    }
    /*private  boolean checkAvailableUserName(UserDTO userDTO) throws Exception {
        User user = userInDtoToUser.map(userDTO);
        Optional<User> exist = userRepository.findByUserName(user.getUserName());
        if(exist.isPresent()) {
            throw new Exception("EL nombre usuario  ya existe ");
        }
    }*/
    private boolean checkPassword(UserDTO userDTO) throws Exception {
        if(!userDTO.getPassword().equals(userDTO.getConfirmPassword())){
            throw new Exception("Las contraseñas no coinciden");
        }
        return true;
    }
    @Override
    public User createUser(UserDTO userDTO) throws Exception {
        User user = userInDtoToUser.map(userDTO);
        if(checkExistEmailAndUserName(userDTO) && checkPassword(userDTO)){
           user= userRepository.save(user);
        }
        return user;
    }

    @Override
    public User getOneUser(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(()->new Exception("El usuario  no existe")) ;
    }

    @Override
    public User updateOneUser(Long id,UserDTO userDTO) throws Exception {
            User userUpdate =userRepository.findById(id).get();
            userUpdate.setLastName(userDTO.getLastName());
            userUpdate.setFirstName(userDTO.getFirstName());
            userUpdate.setUserName(userDTO.getUserName());
            userUpdate.setEmail(userDTO.getEmail());
            return userRepository.save(userUpdate);
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        User user = getOneUser(id);
        userRepository.delete(user);
    }

    @Override
    public User changePassword(ChangePasswordUser changePasswordUser) throws Exception {
        User user = getOneUser(changePasswordUser.getId());
        if(!user.getPassword().equals(changePasswordUser.getCurrentPassword())) {
            throw new Exception("La contraseña actual incorrecta");
        }
        if(user.getPassword().equals(changePasswordUser.getNewPassword())) {
            throw new Exception("La nueva contraseña debe ser diferente a la actual");
        }
        if(!changePasswordUser.getNewPassword().equals(changePasswordUser.getConfirmPassword())) {
            throw new Exception("La nueva contraseña no coincide");
        }
        user.setPassword(changePasswordUser.getNewPassword());

        return userRepository.save(user);
    }


}
