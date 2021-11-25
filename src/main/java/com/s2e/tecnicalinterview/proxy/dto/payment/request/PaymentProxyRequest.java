package com.s2e.tecnicalinterview.proxy.dto.payment.request;

import java.io.Serializable;

import com.s2e.tecnicalinterview.proxy.dto.payment.PaymentCreditor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PaymentProxyRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private PaymentCreditor creditor;
	private String executionDate;
	private String uri;
	private String description;
	private Double amount;
	private String currency;
	private Boolean isUrgent;
	private Boolean isInstant;
	private String feeType;
	private String feeAccountId;
	private PaymentTaxRelief taxRelief;
	
	public PaymentProxyRequest(
			PaymentCreditor creditor, 
			String executionDate, 
			String uri, 
			String description,
			Double amount, 
			String currency, 
			Boolean isUrgent, 
			Boolean isInstant, 
			String feeType, 
			String feeAccountId,
			PaymentTaxRelief taxRelief
			) {
		
		super();
		
		this.creditor = creditor;
		this.executionDate = executionDate;
		this.uri = uri;
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		this.isUrgent = isUrgent;
		this.isInstant = isInstant;
		this.feeType = feeType;
		this.feeAccountId = feeAccountId;
		this.taxRelief = taxRelief;
		
	}
	
}