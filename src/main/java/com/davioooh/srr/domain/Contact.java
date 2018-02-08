package com.davioooh.srr.domain;

import lombok.Data;

@Data
public class Contact {
    private long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

}