package com.petrol_pump.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petrol_pump.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // You can add custom queries here if needed
}
