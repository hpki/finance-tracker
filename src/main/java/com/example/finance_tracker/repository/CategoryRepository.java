package com.example.finance_tracker.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finance_tracker.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
