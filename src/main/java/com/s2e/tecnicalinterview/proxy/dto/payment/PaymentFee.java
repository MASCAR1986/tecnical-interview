package com.s2e.tecnicalinterview.proxy.dto.payment;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PaymentFee implements Serializable{

	private static final long serialVersionUID = 1L;

	private String feeCode;
	private String description;
	private Double amount;
    private String currency;
    
	public PaymentFee(
			String feeCode, 
			String description, 
			Double amount, 
			String currency
			) {
		
		super();
		
		this.feeCode = feeCode;
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		
	}
    	
}