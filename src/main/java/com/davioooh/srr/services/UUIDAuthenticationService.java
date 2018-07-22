package com.davioooh.srr.services;

import com.davioooh.srr.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Profile({"default", "uuid"})
@Service
public class UUIDAuthenticationService implements UserAuthenticationService {
    @Autowired
    private UserService userService;

    @Override
    public String login(String username, String password) {
        return userService.getByUsername(username)
                .filter(u -> u.getPassword().equals(password))
                .map(u -> {
                    u.setToken(UUID.randomUUID().toString());
                    userService.save(u);
                    return u.getToken();
                })
                .orElseThrow(() -> new BadCredentialsException("Invalid username or password."));
    }

    @Override
    public User authenticateByToken(String token) {
        return userService.getByToken(token)
                .orElseThrow(() -> new BadCredentialsException("Token not found."));
    }

    @Override
    public void logout(String username) {
        userService.getByUsername(username)
                .ifPresent(u -> {
                    u.setToken(null);
                    userService.save(u);
                });
    }
}
