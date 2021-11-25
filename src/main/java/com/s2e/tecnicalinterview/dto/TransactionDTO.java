package com.s2e.tecnicalinterview.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TransactionDTO {

	private String transactionId;
	private String operationId;
	private String accountingDate;
	private String valueDate;
	private String enumeration;
	private String value;
    private Double amount;
    private String currency;
    private String description;
    
	public TransactionDTO(
			String transactionId, 
			String operationId, 
			String accountingDate, 
			String valueDate,
			String enumeration,
			String value,
			Double amount,
			String currency,
			String description
			) {
		
		super();
		
		this.transactionId = transactionId;
		this.operationId = operationId;
		this.accountingDate = accountingDate;
		this.valueDate = valueDate;
		this.enumeration = enumeration;
		this.value = value;
		this.amount = amount;
		this.currency = currency;
		this.description = description;
		
	}
	
}