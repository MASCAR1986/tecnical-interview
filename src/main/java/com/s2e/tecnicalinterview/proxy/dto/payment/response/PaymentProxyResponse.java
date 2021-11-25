package com.s2e.tecnicalinterview.proxy.dto.payment.response;

import java.io.Serializable;
import java.util.List;

import com.s2e.tecnicalinterview.proxy.dto.payment.PaymentAmount;
import com.s2e.tecnicalinterview.proxy.dto.payment.PaymentCreditor;
import com.s2e.tecnicalinterview.proxy.dto.payment.PaymentFee;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PaymentProxyResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String moneyTransferId;
	private String status;
	private String direction;
	private PaymentCreditor creditor; 
	private PaymentCreditor debtor;
	private String cro;
	private String uri;
	private String trn;
	private String description;
	private String createdDatetime;
	private String accountedDatetime;
	private String debtorValueDate;
	private String creditorValueDate;
	private PaymentAmount amount;
	private Boolean isUrgent;
	private Boolean isInstant;
	private String feeType;
	private String feeAccountId;
	private List<PaymentFee> fees;
	private Boolean hasTaxRelief;
	
	public PaymentProxyResponse(
			String moneyTransferId,
			String status,
			String direction,
			PaymentCreditor creditor,
			PaymentCreditor debtor,
			String cro, 
			String uri, 
			String trn, 
			String description, 
			String createdDatetime,
			String accountedDatetime, 
			String debtorValueDate, 
			String creditorValueDate, 
			PaymentAmount amount,
			Boolean isUrgent, 
			Boolean isInstant, 
			String feeType, 
			String feeAccountId, 
			List<PaymentFee> fees,
			Boolean hasTaxRelief
			) {
		
		super();
		
		this.moneyTransferId = moneyTransferId;
		this.status = status;
		this.direction = direction;
		this.creditor = creditor;
		this.debtor = debtor;
		this.cro = cro;
		this.uri = uri;
		this.trn = trn;
		this.description = description;
		this.createdDatetime = createdDatetime;
		this.accountedDatetime = accountedDatetime;
		this.debtorValueDate = debtorValueDate;
		this.creditorValueDate = creditorValueDate;
		this.amount = amount;
		this.isUrgent = isUrgent;
		this.isInstant = isInstant;
		this.feeType = feeType;
		this.feeAccountId = feeAccountId;
		this.fees = fees;
		this.hasTaxRelief = hasTaxRelief;
		
	}
	
}