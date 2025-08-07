package com.example.finance_tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.finance_tracker.dto.UsersDto;
import com.example.finance_tracker.mapper.UsersMammer;
import com.example.finance_tracker.model.Users;
import com.example.finance_tracker.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*/
    @PostMapping
    public Users create(@RequestBody Users user) {
        System.out.println(">>> Получен пользователь: " + user.getUserName());
        return userRepository.save(user);
    }

    @GetMapping
    public List<Users> getAll() {
        return userRepository.findAll();
    }
    */

    @PostMapping
    public UsersDto createUsersDto(@Valid @RequestBody UsersDto usersDto) {
        // Преобразуем UsersDto в Users
        Users user = UsersMammer.toEntity(usersDto);
        return UsersMammer.toDto(userRepository.save(user));
    }

    @GetMapping
    public List<UsersDto> getAllUsers() {
        return userRepository.findAll().stream()
            .map(UsersMammer::toDto)
            .toList();
    }

    @GetMapping("/{id}")
    public UsersDto getUserById(@PathVariable Long id) {
        Users user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        return UsersMammer.toDto(user);
    }




  /*  @GetMapping("/all")
public List<Users> getAll() {
    return userRepository.findAll();
}
*/

}

