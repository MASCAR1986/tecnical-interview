package com.s2e.tecnicalinterview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
public class PaymentException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PaymentException(String message) {
		
		super(message);
	
	}
	
}
