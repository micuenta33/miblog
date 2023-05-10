package com.example.ejemploweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String userName;
    @Column(name ="last_name" )
    private String lastName;
    @Column(name ="first_name" )
    private String firstName;
    @Column(nullable = false)
    private String password;
    @Column(unique = true,nullable = false)
    private String email;
}
