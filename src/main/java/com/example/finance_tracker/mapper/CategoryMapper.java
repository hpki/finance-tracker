package com.example.finance_tracker.mapper;

import com.example.finance_tracker.dto.CategoryDto;
import com.example.finance_tracker.model.Category;

public class CategoryMapper {

    public static CategoryDto toDto(Category category) {
        if (category == null) {
            return null;
        }
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    public static Category toEntity(CategoryDto dto) {
        if (dto == null) {
            return null;
        }
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }

}
