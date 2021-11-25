package com.s2e.tecnicalinterview.proxy.dto.transaction;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TransactionProxyDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String transactionId;
	private String operationId;
	private String accountingDate;
	private String valueDate;
	private TransactionProxyTypeDTO type;
    private Double amount;
    private String currency;
    private String description;
	
}