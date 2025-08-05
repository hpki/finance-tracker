package com.example.finance_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.finance_tracker.model.Users;


public interface UserRepository extends JpaRepository<Users, Long> {
    
}

    

