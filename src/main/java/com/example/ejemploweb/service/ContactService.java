package com.example.ejemploweb.service;

import com.example.ejemploweb.DTO.ContactDTO;
import com.example.ejemploweb.entity.Contact;

public interface ContactService {
    void saveContact(ContactDTO contactDTO);
}
