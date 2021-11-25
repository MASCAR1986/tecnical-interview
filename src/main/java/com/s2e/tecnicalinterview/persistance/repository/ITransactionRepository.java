package com.s2e.tecnicalinterview.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.s2e.tecnicalinterview.persistance.model.Transaction;

public interface ITransactionRepository extends JpaRepository<Transaction, String>{

}
