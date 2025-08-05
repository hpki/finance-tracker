package com.example.finance_tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;


import com.example.finance_tracker.model.Users;
import com.example.finance_tracker.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   /* @GetMapping
    public List<Users> getAll() {
        return userRepository.findAll();
    }
    

    @PostMapping
    public Users create(@RequestBody Users user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public Users getById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow();
    }
        */

        @PostMapping
    public Users create(@RequestBody Users user) {
        System.out.println(">>> Получен пользователь: " + user.getUserName());
        return userRepository.save(user);
    }

    @GetMapping
    public List<Users> getAll() {
        return userRepository.findAll();
    }

}
