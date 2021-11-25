package com.s2e.tecnicalinterview.dto;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TransactionResponse {

	private List<TransactionDTO> transactions;

	public TransactionResponse(List<TransactionDTO> transactions) {
		
		super();
		
		this.transactions = transactions;
		
	}
	
}