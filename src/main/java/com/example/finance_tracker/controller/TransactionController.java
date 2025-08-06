package com.example.finance_tracker.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;

import com.example.finance_tracker.dto.TransactionDto;
import com.example.finance_tracker.mapper.TransactionMapper;
import com.example.finance_tracker.model.Category;
import com.example.finance_tracker.model.Transaction;
import com.example.finance_tracker.model.Users;
import com.example.finance_tracker.repository.TransactionRepository;
import com.example.finance_tracker.repository.CategoryRepository;
import com.example.finance_tracker.repository.UserRepository;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public TransactionController(TransactionRepository transactionRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    /*@GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }*/

    /*@PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {

        // загружаем category и user вручную
    Category category = categoryRepository.findById(transaction.getCategory().getId())
        .orElseThrow(() -> new RuntimeException("Категория не найдена"));
    Users user = userRepository.findById(transaction.getUser().getId())
        .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

    transaction.setCategory(category);
    transaction.setUser(user);

        return transactionRepository.save(transaction);
    }
        */

        @GetMapping
        public List<TransactionDto> getAllTransactions() {
            return transactionRepository.findAll().stream()
        .map(TransactionMapper::toDto)
        .toList();
        }

        @PostMapping
        public TransactionDto createTransaction(@RequestBody TransactionDto transactionDto) {
            // загружаем category и user вручную
            Category category = categoryRepository.findById(transactionDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Категория не найдена"));
            Users user = userRepository.findById(transactionDto.getUserId())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

            Transaction transaction = TransactionMapper.toEntity(transactionDto, category, user);

            Transaction savedTransaction = transactionRepository.save(transaction);
            return TransactionMapper.toDto(savedTransaction);
        }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionRepository.findById(id)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction updatedTransaction) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow();
        transaction.setAmount(updatedTransaction.getAmount());
        transaction.setDescription(updatedTransaction.getDescription());
        transaction.setCategory(updatedTransaction.getCategory());
        return transactionRepository.save(transaction);
    }
}
