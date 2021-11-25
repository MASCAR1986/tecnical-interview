package com.s2e.tecnicalinterview.proxy.dto.payment.request;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PaymentNaturalBeneficiary implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String fiscalCode1;
	private String fiscalCode2;
	private String fiscalCode3;
	private String fiscalCode4;
	private String fiscalCode5;
	
	public PaymentNaturalBeneficiary(
			String fiscalCode1, 
			String fiscalCode2, 
			String fiscalCode3, 
			String fiscalCode4,
			String fiscalCode5
			) {
		
		super();
		
		this.fiscalCode1 = fiscalCode1;
		this.fiscalCode2 = fiscalCode2;
		this.fiscalCode3 = fiscalCode3;
		this.fiscalCode4 = fiscalCode4;
		this.fiscalCode5 = fiscalCode5;
		
	}
	
}