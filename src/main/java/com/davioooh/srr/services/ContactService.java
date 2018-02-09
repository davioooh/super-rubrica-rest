package com.davioooh.srr.services;

import com.davioooh.srr.domain.Contact;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private List<Contact> db;

    public ContactService() {
        db = Lists.newArrayList(
                new Contact(Long.valueOf(1), "Mario", "Rossi", "3332345678", "m.rossi@red.it"),
                new Contact(Long.valueOf(2), "Francesca", "Gialli", "3332233444", "francesca.g@yllw.com"),
                new Contact(Long.valueOf(3), "Marco", "Verdi", "3334545456", "marco.verdi@vmail.com")

        );
    }

    public List<Contact> getList() {
        return ImmutableList.copyOf(db);
    }

    public Contact getById(Long id) {
        return db.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Contact save(Contact contactForm) {
        // TODO da implementare
        return null;
    }

    public void delete(long id) {
        // TODO da implementare
    }
}
