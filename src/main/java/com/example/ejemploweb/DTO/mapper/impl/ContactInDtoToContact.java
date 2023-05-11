package com.example.ejemploweb.DTO.mapper.impl;

import com.example.ejemploweb.DTO.ContactDTO;
import com.example.ejemploweb.DTO.mapper.IMapper;
import com.example.ejemploweb.entity.Contact;

import org.springframework.stereotype.Component;

@Component
public class ContactInDtoToContact implements IMapper<ContactDTO, Contact> {
    @Override
    public Contact map(ContactDTO in) {
        return null;
    }
}
