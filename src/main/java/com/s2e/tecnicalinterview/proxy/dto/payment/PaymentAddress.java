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
public class PaymentAddress implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String address;
	private String city;
	private String countryCode;
	
	public PaymentAddress(
			String address, 
			String city, 
			String countryCode
			) {
		
		super();
		
		this.address = address;
		this.city = city;
		this.countryCode = countryCode;
		
	}
	
}