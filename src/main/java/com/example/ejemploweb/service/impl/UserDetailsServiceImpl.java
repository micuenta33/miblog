package com.example.ejemploweb.service.impl;

import com.example.ejemploweb.entity.Role;
import com.example.ejemploweb.repository.UserRepository;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       com.example.ejemploweb.entity.User appUser = userRepository.findByUserName(username)
               .orElseThrow(()-> new UsernameNotFoundException("El nombre de usuario no existe"));
       Set grantList=new HashSet();
        for (Role roles:appUser.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roles.getName());
            grantList.add(grantedAuthority);
        }
        UserDetails userDetails = new User(appUser.getUserName(),appUser.getPassword(),grantList);

        return userDetails;
    }

}
