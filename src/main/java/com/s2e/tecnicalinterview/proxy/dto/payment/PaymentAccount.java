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
public class PaymentAccount implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String accountCode;
	private String bicCode;
	
	public PaymentAccount(
			String accountCode, 
			String bicCode
			) {
		
		super();
		
		this.accountCode = accountCode;
		this.bicCode = bicCode;
		
	}
	
}