package com.s2e.tecnicalinterview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.s2e.tecnicalinterview.dto.AccountInfoResponse;
import com.s2e.tecnicalinterview.dto.BalanceResponse;
import com.s2e.tecnicalinterview.dto.PaymentResponse;
import com.s2e.tecnicalinterview.dto.TransactionResponse;
import com.s2e.tecnicalinterview.service.ITecnicalInterviewService;

@RestController
public class TecnicalInterviewController {

	@Autowired
	private ITecnicalInterviewService service;
	
	@GetMapping(value = "/accountInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountInfoResponse> getInfo(){

		AccountInfoResponse result = service.getAccountInfo();
		
		return ResponseEntity.ok().body(result);
		
	}
	
	@GetMapping(value = "/balance", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BalanceResponse> getBalance(){
		
		BalanceResponse result = service.getBalance();
		
		return ResponseEntity.ok().body(result);
		
	}
	
	@GetMapping(value = "/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionResponse> getTransaction(
			@RequestParam(name = "batched", required = false) boolean batched
			){
		
		TransactionResponse result;
		
		if(batched)
			result = service.getSavedTransactionList();
		else
			result = service.getTransactionList();
		
		return ResponseEntity.ok().body(result);
		
	}
	
	@GetMapping(value = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentResponse> getPayment(){
		
		PaymentResponse result = service.sendPayment();
		
		return ResponseEntity.ok().body(result);
		
	}
	
}