package com.s2e.tecnicalinterview.proxy.dto;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ProxyResponse<T> {

	private String status;
	private List<String> error;
	private T payload;
	
}