package com.example.finance_tracker.mapper;

import com.example.finance_tracker.dto.TransactionDto;
import com.example.finance_tracker.model.Transaction;
import com.example.finance_tracker.model.TransactionType;
import com.example.finance_tracker.model.Category;
import com.example.finance_tracker.model.Users;

public class TransactionMapper {

    public static Transaction toEntity(TransactionDto dto, Category category, Users user) {
        Transaction transaction = new Transaction();
        transaction.setId(dto.getId());
        transaction.setAmount(dto.getAmount());
        transaction.setDescription(dto.getDescription());
        transaction.setDate(dto.getDate());
        transaction.setType(TransactionType.valueOf(dto.getType()));
        transaction.setCategory(category);
        transaction.setUser(user);
        return transaction;
    }

    public static TransactionDto toDto(Transaction transaction) {
        TransactionDto dto = new TransactionDto();
        dto.setId(transaction.getId());
        dto.setAmount(transaction.getAmount());
        dto.setDescription(transaction.getDescription());
        dto.setDate(transaction.getDate());
        dto.setType(transaction.getType().name());
        dto.setCategoryId(transaction.getCategory().getId());
        dto.setUserId(transaction.getUser().getId());
        return dto;
    }
}