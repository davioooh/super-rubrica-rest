package com.davioooh.srr.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "contacts")
public class Contact {
    @Id
    private String id;
    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull String phone;
    private @NonNull String email;

}