package com.example.ejemploweb.exception.user;

public class UserNameOrIdNotFund extends Exception {

    public UserNameOrIdNotFund(String message) {
        super(message);
    }

    public UserNameOrIdNotFund() {
        super("Usuario o el id no encontrado");

    }
}
