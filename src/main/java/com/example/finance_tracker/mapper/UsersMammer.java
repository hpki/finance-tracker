package com.example.finance_tracker.mapper;

import com.example.finance_tracker.dto.UsersDto;
import com.example.finance_tracker.model.Users;

public class UsersMammer {

    // Здесь можно добавить методы для преобразования между Users и UsersDto
    // Например, toDto и toEntity методы для конвертации между сущностями и DTO

    // Пример метода для преобразования Users в UsersDto
    public static UsersDto toDto(Users user) {
        if (user == null) {
            return null;
        }
        UsersDto dto = new UsersDto();
        dto.setId(user.getId());
        dto.setUserName(user.getUserName());
        dto.setEmail(user.getEmail());
        //dto.setPassword(user.getPassword()); !!! не возвращаем пароль в DTO
        return dto;
    }

    // Пример метода для преобразования UsersDto в Users
    public static Users toEntity(UsersDto dto) {
        if (dto == null) {
            return null;
        }
        Users user = new Users();
        user.setId(dto.getId());
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

}
