package com.s2e.tecnicalinterview.persistance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TRANSACTION_ID")
	private String transactionId;
	
	@Column(name = "OPERATION_ID")
	private String operationId;
	
	@Column(name = "ACCOUNTING_DATE")
	private String accountingDate;
	
	@Column(name = "VALUE_DATE")
	private String valueDate;
	
	@Column(name = "ENUMERATION")
	private String enumeration;
	
	@Column(name = "VALUE")
	private String value;
	
	@Column(name = "AMOUNT")
    private Double amount;
	
	@Column(name = "CURRENCY")
    private String currency;
	
	@Column(name = "DESCRIPTION")
    private String description;

	public Transaction(
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