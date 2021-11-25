package com.s2e.tecnicalinterview.service;

import com.s2e.tecnicalinterview.dto.AccountInfoResponse;
import com.s2e.tecnicalinterview.dto.BalanceResponse;
import com.s2e.tecnicalinterview.dto.PaymentResponse;
import com.s2e.tecnicalinterview.dto.TransactionResponse;

public interface ITecnicalInterviewService {

	public AccountInfoResponse getAccountInfo();	
	public BalanceResponse getBalance();
	public TransactionResponse getTransactionList();
	public TransactionResponse getSavedTransactionList();
	public PaymentResponse sendPayment();
	
}
