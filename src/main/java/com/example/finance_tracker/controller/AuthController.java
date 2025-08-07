package com.example.finance_tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finance_tracker.config.JwtUtils;
import com.example.finance_tracker.dto.AuthRequest;
import com.example.finance_tracker.dto.AuthResponce;
import com.example.finance_tracker.dto.RegisterRequest;
import com.example.finance_tracker.model.Users;
import com.example.finance_tracker.repository.UserRepository;
import com.example.finance_tracker.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final JwtUtils jwtUtils;

    private final UserRepository userRepository; // Добавь это

    public AuthController(UserService userService, JwtUtils jwtUtils, UserRepository userRepository) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public Users register(@RequestBody RegisterRequest registerRequest) {
        return userService.register(registerRequest);
    }

    @PostMapping("/login")
    public AuthResponce login(@RequestBody AuthRequest authRequest) {
        Users user = userService.authenticate(authRequest);
        String token = jwtUtils.generateToken(user.getEmail());
        return new AuthResponce(token);
    }

    // ВРЕМЕННО: Получение всех пользователей
    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

}
