package com.s2e.tecnicalinterview.dto;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BalanceResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private String date;
    private Double balance;
    private Double availableBalance;
    private String currency;
    
	public BalanceResponse(
			String date,
			Double balance, 
			Double availableBalance, 
			String currency
			) {
		
		super();
		
		this.date = date;
		this.balance = balance;
		this.availableBalance = availableBalance;
		this.currency = currency;
		
	}
	  
}