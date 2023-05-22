package com.example.ejemploweb.service.impl;

import com.example.ejemploweb.DTO.ContactDTO;
import com.example.ejemploweb.DTO.mapper.impl.ContactInDtoToContact;
import com.example.ejemploweb.entity.Contact;
import com.example.ejemploweb.repository.ContactRepository;
import com.example.ejemploweb.service.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactInDtoToContact contactInDtoToContact;

    public ContactServiceImpl(ContactRepository contactRepository, ContactInDtoToContact contactInDtoToContact) {
        this.contactRepository = contactRepository;
        this.contactInDtoToContact = contactInDtoToContact;
    }

    @Override
    public void saveContact(ContactDTO contactDTO) {
        Contact contact=contactInDtoToContact.map(contactDTO);
        contactRepository.save(contact);
    }
}
