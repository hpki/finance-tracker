package com.example.finance_tracker.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoryDto {

    private Long id;

    @NotBlank(message = "Название категории не может быть пустым")
    private String name;

     // --- Геттеры и сеттеры ---
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
