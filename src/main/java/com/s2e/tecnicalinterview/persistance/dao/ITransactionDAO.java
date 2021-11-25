package com.s2e.tecnicalinterview.persistance.dao;

import java.util.List;

import com.s2e.tecnicalinterview.persistance.model.Transaction;

public interface ITransactionDAO {

	public void saveAllTransaction(List<Transaction> toSaveList);	
	public List<Transaction> getAllSavedTransaction();
	
}
