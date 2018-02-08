package com.davioooh.srr.controllers;

import com.davioooh.srr.domain.Contact;
import com.davioooh.srr.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("")
    public List<Contact> getAll() {
        return contactService.getList();
    }

    @GetMapping("/{id}")
    public Contact getById(@PathVariable("id") long id) {
        return contactService.getById(id);
    }

    @PostMapping("")
    public Contact create(Contact contact) {
        return contactService.save(contact);
    }

    @PutMapping("/{id)")
    public Contact update(@PathVariable("id") long id, Contact contact) {
        return contactService.save(contact);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        contactService.delete(id);
    }

}
