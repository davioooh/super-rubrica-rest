package com.davioooh.srr.services;

import com.davioooh.srr.domain.User;
import org.springframework.security.authentication.BadCredentialsException;

public interface UserAuthenticationService {
    String login(String username, String password) throws BadCredentialsException;
    void logout(User user);
}