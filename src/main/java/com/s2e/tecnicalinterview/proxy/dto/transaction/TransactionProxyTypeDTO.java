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
public class TransactionProxyTypeDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String enumeration;
	private String value;
	
}
