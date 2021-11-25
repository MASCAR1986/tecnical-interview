package com.s2e.tecnicalinterview.proxy.dto.account;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AccountInfoProxyListDTO {

	private List<AccountInfoProxyDTO> list;
	
}