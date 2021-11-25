package com.s2e.tecnicalinterview.proxy.dto.balance;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BalanceProxyDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String date;
    private Double balance;
    private Double availableBalance;
    private String currency;
	
}
