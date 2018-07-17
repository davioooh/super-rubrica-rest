package com.davioooh.srr.services;

import com.davioooh.srr.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDAuthenticationService implements UserAuthenticationService {
    @Autowired
    private UserService userService;

    @Override
    public String login(String username, String password) {
        return userService.getByUsername(username)
                .filter(u -> u.getPassword().equals(password))
                .map(u -> {
                    String token = UUID.randomUUID().toString();
                    u.setToken(token);
                    userService.save(u);
                    return token;
                })
                .orElseThrow(() -> new BadCredentialsException("Invalid username or password."));
    }

    @Override
    public void logout(User user) {

    }
}
