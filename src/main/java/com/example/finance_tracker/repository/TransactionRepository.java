package com.example.finance_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finance_tracker.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
