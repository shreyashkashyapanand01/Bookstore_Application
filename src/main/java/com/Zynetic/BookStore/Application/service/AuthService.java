package com.Zynetic.BookStore.Application.service;

import com.Zynetic.BookStore.Application.entity.User;
import com.Zynetic.BookStore.Application.repo.UserRepo;
import com.Zynetic.BookStore.Application.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String signup(String email, String password) {
        if (userRepo.findByEmail(email).isPresent()) throw new RuntimeException("User already exists");
        String hashedPassword = encoder.encode(password);
        userRepo.save(User.builder().email(email).password(hashedPassword).build());
        return "User registered successfully";
    }

    public String login(String email, String password) {
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isPresent() && encoder.matches(password, user.get().getPassword())) {
            return jwtUtil.generateToken(email);
        }
        throw new RuntimeException("Invalid credentials");
    }
}