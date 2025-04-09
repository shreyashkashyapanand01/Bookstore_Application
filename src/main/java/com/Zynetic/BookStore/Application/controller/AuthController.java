package com.Zynetic.BookStore.Application.controller;


import com.Zynetic.BookStore.Application.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestBody Map<String, String> request) {
        return authService.signup(request.get("email"), request.get("password"));
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> request) {
        return authService.login(request.get("email"), request.get("password"));
    }
}