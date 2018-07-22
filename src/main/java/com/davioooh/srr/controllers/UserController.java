package com.davioooh.srr.controllers;

import com.davioooh.srr.services.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserAuthenticationService authenticationService;

    @GetMapping("/profile")
    public User profile(@AuthenticationPrincipal User user) {
        return user;
    }

    @PostMapping("/logout")
    public void logout(@AuthenticationPrincipal User user) {
        authenticationService.logout(user.getUsername());
    }
}
