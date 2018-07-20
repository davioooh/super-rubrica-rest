package com.davioooh.srr;

import com.davioooh.srr.domain.Contact;
import com.davioooh.srr.domain.User;
import com.davioooh.srr.repositories.ContactRepository;
import com.davioooh.srr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MongoInitStartupRunner implements ApplicationRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(!userRepository.findByUsername("user").isPresent()){
            User user = new User();
            user.setUsername("user");
            user.setPassword("pwd1234");

            userRepository.save(user);
        }

        if (contactRepository.findAll().isEmpty()) {
            Contact contact1 = new Contact();
            contact1.setFirstName("Roberto");
            contact1.setLastName("Rossi");
            contact1.setPhone("5552233444");
            contact1.setEmail("rob@red.com");

            Contact contact2 = new Contact();
            contact2.setFirstName("Valerio");
            contact2.setLastName("Verdi");
            contact2.setPhone("5552244888");
            contact2.setEmail("rv.verdi@pippo.it");

            contactRepository.saveAll(Arrays.asList(contact1, contact2));
        }
    }
}