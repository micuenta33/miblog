package com.example.ejemploweb.DTO.mapper.impl;

import com.example.ejemploweb.DTO.ContactDTO;
import com.example.ejemploweb.DTO.mapper.IMapper;
import com.example.ejemploweb.entity.Contact;

import org.springframework.stereotype.Component;

@Component
public class ContactInDtoToContact implements IMapper<ContactDTO, Contact> {
    @Override
    public Contact map(ContactDTO in) {
        Contact contact=new Contact();
        contact.setName(in.getName());
        contact.setEmail(in.getEmail());
        contact.setSubject(in.getSubject());
        contact.setMessage(in.getMessage());
        return contact;
    }
}
