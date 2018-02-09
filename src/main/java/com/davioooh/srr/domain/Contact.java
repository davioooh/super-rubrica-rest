package com.davioooh.srr.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contact {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

}