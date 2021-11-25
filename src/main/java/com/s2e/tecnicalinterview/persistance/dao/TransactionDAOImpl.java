package com.s2e.tecnicalinterview.persistance.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.s2e.tecnicalinterview.persistance.model.Transaction;
import com.s2e.tecnicalinterview.persistance.repository.ITransactionRepository;

@Repository
public class TransactionDAOImpl implements ITransactionDAO{

	@Autowired
	private ITransactionRepository repository;
	
	@Override
	public void saveAllTransaction(List<Transaction> toSaveList) {
		
		repository.saveAll(toSaveList);
		
	}
	
	@Override
	public List<Transaction> getAllSavedTransaction(){
		
		return repository.findAll();
		
	}

}