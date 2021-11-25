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
public class AccountInfoResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String accountId;
	private String iban;
	private String abiCode;
	private String cabCode;
	private String countryCode;
	private String internationalCin;
	private String account;
	private String alias;
	private String productName;
	private String holderName;
	private String activatedDate;
	private String currency;
	
	public AccountInfoResponse(
			String accountId, 
			String iban, 
			String abiCode, 
			String cabCode,
			String countryCode,
			String internationalCin, 
			String account, 
			String alias,
			String productName,
			String holderName,
			String activatedDate,
			String currency
			) {
		
		super();
		
		this.accountId = accountId;
		this.iban = iban;
		this.abiCode = abiCode;
		this.cabCode = cabCode;
		this.countryCode = countryCode;
		this.internationalCin = internationalCin;
		this.account = account;
		this.alias = alias;
		this.productName = productName;
		this.holderName = holderName;
		this.activatedDate = activatedDate;
		this.currency = currency;
		
	}

}