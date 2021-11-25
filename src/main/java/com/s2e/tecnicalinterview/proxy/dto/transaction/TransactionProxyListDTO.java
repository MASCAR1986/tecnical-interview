package com.s2e.tecnicalinterview.proxy.dto.transaction;

import java.io.Serializable;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TransactionProxyListDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<TransactionProxyDTO> list;
	
}
