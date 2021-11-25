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
public class PaymentCreditor implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private PaymentAccount account;
	private PaymentAddress address;
	
	public PaymentCreditor(
			String name, 
			PaymentAccount account, 
			PaymentAddress address
			) {
		
		super();
		
		this.name = name;
		this.account = account;
		this.address = address;
		
	}
	
}