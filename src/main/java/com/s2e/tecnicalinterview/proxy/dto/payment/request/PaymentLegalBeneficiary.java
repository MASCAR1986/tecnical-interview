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
public class PaymentLegalBeneficiary implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String fiscalCode;
	private String legalRepresentativeFiscalCode;
	
	public PaymentLegalBeneficiary(
			String fiscalCode, 
			String legalRepresentativeFiscalCode
			) {
		
		super();
		
		this.fiscalCode = fiscalCode;
		this.legalRepresentativeFiscalCode = legalRepresentativeFiscalCode;
		
	}
	
}