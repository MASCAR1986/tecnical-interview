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
public class PaymentAmount implements Serializable{

	private static final long serialVersionUID = 1L;

	private Double debtorAmount;
    private String debtorCurrency;
    private Double creditorAmount;
    private String creditorCurrency;
    private String creditorCurrencyDate;
    private Double exchangeRate;
    
	public PaymentAmount(
			Double debtorAmount, 
			String debtorCurrency, 
			Double creditorAmount, 
			String creditorCurrency,
			String creditorCurrencyDate,
			Double exchangeRate
			) {
		
		super();
		
		this.debtorAmount = debtorAmount;
		this.debtorCurrency = debtorCurrency;
		this.creditorAmount = creditorAmount;
		this.creditorCurrency = creditorCurrency;
		this.creditorCurrencyDate = creditorCurrencyDate;
		this.exchangeRate = exchangeRate;
		
	}
    
}