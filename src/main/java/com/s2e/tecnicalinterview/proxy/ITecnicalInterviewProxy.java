package com.s2e.tecnicalinterview.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.s2e.tecnicalinterview.proxy.dto.ProxyResponse;
import com.s2e.tecnicalinterview.proxy.dto.account.AccountInfoProxyListDTO;
import com.s2e.tecnicalinterview.proxy.dto.balance.BalanceProxyDTO;
import com.s2e.tecnicalinterview.proxy.dto.transaction.TransactionProxyListDTO;

@FeignClient(name = "tecnical-proxy", url = "${proxy.url}")
public interface ITecnicalInterviewProxy {

	@RequestMapping(value = "/api/gbs/banking/v4.0/accounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProxyResponse<AccountInfoProxyListDTO> getAccountInfo(@RequestHeader(value = "Auth-Schema") String authSchema, @RequestHeader(value = "apikey") String apiKey);
	
	@RequestMapping(value = "/api/gbs/banking/v4.0/accounts/{accountId}/balance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProxyResponse<BalanceProxyDTO> getBalance(@RequestHeader(value = "Auth-Schema") String authSchema, @RequestHeader(value = "apikey") String apiKey, @PathVariable(name = "accountId") Long accountId);
	
	@RequestMapping(value = "/api/gbs/banking/v4.0/accounts/{accountId}/transactions?fromAccountingDate={fromAccountingDate}&toAccountingDate={toAccountingDate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProxyResponse<TransactionProxyListDTO> getTransaction(@RequestHeader(value = "Auth-Schema") String authSchema, @RequestHeader(value = "apikey") String apiKey, @PathVariable(name = "accountId") Long accountId, @PathVariable(name = "fromAccountingDate") String fromAccountingDate, @PathVariable(name = "toAccountingDate") String toAccountingDate);

	@RequestMapping(value = "/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProxyResponse<TransactionProxyListDTO> addMoney(@RequestHeader(value = "Auth-Schema") String authSchema, @RequestHeader(value = "apikey") String apiKey, @PathVariable(name = "accountId") Long accountId, @PathVariable(name = "fromAccountingDate") String fromAccountingDate, @PathVariable(name = "toAccountingDate") String toAccountingDate);

}