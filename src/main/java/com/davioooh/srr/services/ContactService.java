package com.davioooh.srr.services;

import com.davioooh.srr.domain.Contact;
import com.davioooh.srr.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getList() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getById(String id) {
        return contactRepository.findById(id);
    }

    public Contact create(Contact contact) {
        return contactRepository.insert(contact);
    }

    public Contact update(Contact contact) {
        return contactRepository.save(contact);
    }

    public void delete(String id) {
        contactRepository.deleteById(id);
    }
}
