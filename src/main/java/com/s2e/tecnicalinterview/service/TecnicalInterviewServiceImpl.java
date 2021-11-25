package com.s2e.tecnicalinterview.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.s2e.tecnicalinterview.dto.AccountInfoResponse;
import com.s2e.tecnicalinterview.dto.BalanceResponse;
import com.s2e.tecnicalinterview.dto.PaymentResponse;
import com.s2e.tecnicalinterview.dto.TransactionDTO;
import com.s2e.tecnicalinterview.dto.TransactionResponse;
import com.s2e.tecnicalinterview.exception.PaymentException;
import com.s2e.tecnicalinterview.persistance.dao.ITransactionDAO;
import com.s2e.tecnicalinterview.persistance.model.Transaction;
import com.s2e.tecnicalinterview.proxy.ITecnicalInterviewProxy;
import com.s2e.tecnicalinterview.proxy.dto.ProxyResponse;
import com.s2e.tecnicalinterview.proxy.dto.account.AccountInfoProxyDTO;
import com.s2e.tecnicalinterview.proxy.dto.account.AccountInfoProxyListDTO;
import com.s2e.tecnicalinterview.proxy.dto.balance.BalanceProxyDTO;
import com.s2e.tecnicalinterview.proxy.dto.payment.PaymentAccount;
import com.s2e.tecnicalinterview.proxy.dto.payment.PaymentAddress;
import com.s2e.tecnicalinterview.proxy.dto.payment.PaymentCreditor;
import com.s2e.tecnicalinterview.proxy.dto.payment.request.PaymentLegalBeneficiary;
import com.s2e.tecnicalinterview.proxy.dto.payment.request.PaymentNaturalBeneficiary;
import com.s2e.tecnicalinterview.proxy.dto.payment.request.PaymentProxyRequest;
import com.s2e.tecnicalinterview.proxy.dto.payment.request.PaymentTaxRelief;
import com.s2e.tecnicalinterview.proxy.dto.payment.response.PaymentProxyResponse;
import com.s2e.tecnicalinterview.proxy.dto.transaction.TransactionProxyDTO;
import com.s2e.tecnicalinterview.proxy.dto.transaction.TransactionProxyListDTO;

@Service
public class TecnicalInterviewServiceImpl implements ITecnicalInterviewService{

	@Autowired
	private ITecnicalInterviewProxy proxyClient;
	
	@Value("${account.id}")
	private Long accountId;
	
	@Value("${proxy.auth-schema}")
	private String authSchema;
	
	@Value("${proxy.api-key}")
	private String apiKey;
	
	@Value("${proxy.x-time-zone}")
	private String xTimeZone;
	
	@Autowired
	private ITransactionDAO dao;
	
	
	@Override
	public AccountInfoResponse getAccountInfo() {

		ProxyResponse<AccountInfoProxyListDTO> proxyResponse = proxyClient.getAccountInfo(authSchema, apiKey);
		List<AccountInfoProxyDTO> responseList = proxyResponse.getPayload().getList();
			
		AccountInfoProxyDTO response = responseList
									   .stream()
									   .filter(entry -> entry.getAccountId().equalsIgnoreCase(""+accountId))
									   .reduce(
											   (first, second) -> {
												   throw new RuntimeException("Multiple result for " + accountId);   
											   }
										).get();
		
		return new AccountInfoResponse(
					response.getAccountId(), 
					response.getIban(), 
					response.getAbiCode(), 
					response.getCabCode(), 
					response.getCountryCode(), 
					response.getInternationalCin(), 
					response.getAccount(), 
					response.getAlias(), 
					response.getProductName(), 
					response.getHolderName(), 
					response.getActivatedDate(), 
					response.getCurrency()
				);

	}

	@Override
	public BalanceResponse getBalance() {
		
		ProxyResponse<BalanceProxyDTO> proxyResponse = proxyClient.getBalance(authSchema, apiKey, accountId);
		BalanceProxyDTO balance = proxyResponse.getPayload();
		
		return new BalanceResponse(
				balance.getDate(), 
				balance.getBalance(), 
				balance.getAvailableBalance(),
				balance.getCurrency()
				);

		
	}

	@Override
	public TransactionResponse getTransactionList() {
		
		ProxyResponse<TransactionProxyListDTO> proxyResponse = proxyClient.getTransaction(authSchema, apiKey, accountId, "2019-01-01", "2019-12-01");
		TransactionProxyListDTO transactionProxyList = proxyResponse.getPayload();
		List<TransactionProxyDTO> transactionProxyValuesList = transactionProxyList.getList();
		
		List<TransactionDTO> resultList = new ArrayList<TransactionDTO>();
		List<Transaction> resultListToSave = new ArrayList<Transaction>();
		for(TransactionProxyDTO transactionProxy : transactionProxyValuesList) {
		
			resultList.add(
					new TransactionDTO(
							transactionProxy.getTransactionId(),
							transactionProxy.getOperationId(), 
							transactionProxy.getAccountingDate(), 
							transactionProxy.getValueDate(), 
							transactionProxy.getType().getEnumeration(), 
							transactionProxy.getType().getValue(), 
							transactionProxy.getAmount(), 
							transactionProxy.getCurrency(), 
							transactionProxy.getDescription()
							)
					);
			
			resultListToSave.add(
					new Transaction(
							transactionProxy.getTransactionId(),
							transactionProxy.getOperationId(), 
							transactionProxy.getAccountingDate(), 
							transactionProxy.getValueDate(), 
							transactionProxy.getType().getEnumeration(), 
							transactionProxy.getType().getValue(), 
							transactionProxy.getAmount(), 
							transactionProxy.getCurrency(), 
							transactionProxy.getDescription()
							)
					);
			
		}
		
		dao.saveAllTransaction(resultListToSave);
		
		return new TransactionResponse(resultList);
		
	}
	
	@Override
	public TransactionResponse getSavedTransactionList() {
		
		List<Transaction> savedTransactionList = dao.getAllSavedTransaction();
		List<TransactionDTO> resultList = new ArrayList<TransactionDTO>();
		for(Transaction transaction : savedTransactionList) {
		
			resultList.add(
					new TransactionDTO(
							transaction.getTransactionId(),
							transaction.getOperationId(), 
							transaction.getAccountingDate(), 
							transaction.getValueDate(), 
							transaction.getEnumeration(), 
							transaction.getValue(), 
							transaction.getAmount(), 
							transaction.getCurrency(), 
							transaction.getDescription()
							)
					);
			
		}
		
		return new TransactionResponse(resultList);
		
	}

	@Override
	public PaymentResponse sendPayment() {
	
		
		ProxyResponse<PaymentProxyResponse> proxyResponse = proxyClient.addMoney(authSchema, apiKey, xTimeZone, accountId, mockPaymentRequest());
		
		if(proxyResponse.getStatus().equalsIgnoreCase("KO"))
			throw new PaymentException(proxyResponse.getError().stream().collect(Collectors.joining(",")));
		
		PaymentProxyResponse paymentResponse = proxyResponse.getPayload();
		
		return new PaymentResponse(paymentResponse.getMoneyTransferId(), paymentResponse.getStatus(), paymentResponse.getDirection());
	
	}

	private PaymentProxyRequest mockPaymentRequest() {
		
		return new PaymentProxyRequest(
				new PaymentCreditor(
						"John Doe", 
						new PaymentAccount("IT23A0336844430152923804660", "SELBIT2BXXX"), 
						new PaymentAddress(null, null, null)
						), 
				"2019-04-01", 
				"REMITTANCE_INFORMATION", 
				"Payment invoice 75/201", 
				800.0, 
				"EUR", 
				new Boolean(false), 
				new Boolean(false), 
				"SHA", 
				""+accountId, 
				new PaymentTaxRelief(
						"L449", 
						new Boolean(false), 
						"56258745832", 
						"NATURAL_PERSON", 
						new PaymentNaturalBeneficiary(
								"MRLFNC81L04A859L", 
								null, 
								null, 
								null, 
								null), 
						new PaymentLegalBeneficiary(
								"56258745832", 
								null
								)
						)
				
				);
				
		
	}
	
}
