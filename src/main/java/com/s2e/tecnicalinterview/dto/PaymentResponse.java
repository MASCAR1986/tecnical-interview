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
public class PaymentResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String moneyTransferId;
	private String status;
	private String direction;
	
	public PaymentResponse(
			String moneyTransferId, 
			String status, 
			String direction
			) {
		
		super();
		
		this.moneyTransferId = moneyTransferId;
		this.status = status;
		this.direction = direction;
		
	}

}