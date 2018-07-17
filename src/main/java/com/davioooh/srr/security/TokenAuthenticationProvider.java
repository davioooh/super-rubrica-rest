package com.davioooh.srr.security;

import com.davioooh.srr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    @Autowired
    private UserService userService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) {
        Object token = authentication.getCredentials();
        return Optional
                .ofNullable(token)
                .map(String::valueOf)
                .flatMap(t -> userService.getByToken(t)
                        .map(u -> User.builder()
                                .username(u.getUsername())
                                .password(u.getPassword())
                                .roles("user")
                                .build()))
                .orElseThrow(() -> new UsernameNotFoundException("Invalid authentication token=" + token));
    }
}