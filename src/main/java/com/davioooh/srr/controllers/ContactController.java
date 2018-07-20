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

    @GetMapping
    public List<Contact> getAll() {
        return contactService.getList();
    }

    @GetMapping("/{id}")
    public Contact getById(@PathVariable("id") String id) {
        return contactService.getById(id)
                .orElse(null);
    }

    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return contactService.create(contact);
    }

    @PutMapping("/{id}")
    public Contact update(@PathVariable("id") String id, @RequestBody Contact contact) {
        return contactService.update(contact);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        contactService.delete(id);
    }

}
