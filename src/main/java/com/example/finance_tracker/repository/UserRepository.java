package com.example.finance_tracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.finance_tracker.model.Users;


public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
}

    

