package com.s2e.tecnicalinterview.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;

@RestControllerAdvice
public class ProxyExceptionHandler {

	@ExceptionHandler(FeignException.class)
    public String manageFeignException(
    		FeignException e, 
    		HttpServletResponse response
    		) {

		
        response.setStatus(e.status());
        
        return e.getMessage();
    
	}
	
}
