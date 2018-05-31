package com.davioooh.srr.repositories;

import com.davioooh.srr.domain.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {
}
