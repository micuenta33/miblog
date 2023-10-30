package com.example.ejemploweb.repository;

import com.example.ejemploweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmailOrUserName(String email, String username);
    Optional<User> findByUserName(String username);
}
