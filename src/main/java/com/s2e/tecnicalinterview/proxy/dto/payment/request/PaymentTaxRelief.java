package com.s2e.tecnicalinterview.proxy.dto.payment.request;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PaymentTaxRelief implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String taxReliefId;
    private Boolean isCondoUpgrade;
    private String creditorFiscalCode;
    private String beneficiaryType;
    private PaymentNaturalBeneficiary naturalPersonBeneficiary;
    private PaymentLegalBeneficiary legalPersonBeneficiary;
    
	public PaymentTaxRelief(
			String taxReliefId, 
			Boolean isCondoUpgrade, 
			String creditorFiscalCode,
			String beneficiaryType,
			PaymentNaturalBeneficiary naturalPersonBeneficiary,
			PaymentLegalBeneficiary legalPersonBeneficiary
			) {
		
		super();
		
		this.taxReliefId = taxReliefId;
		this.isCondoUpgrade = isCondoUpgrade;
		this.creditorFiscalCode = creditorFiscalCode;
		this.beneficiaryType = beneficiaryType;
		this.naturalPersonBeneficiary = naturalPersonBeneficiary;
		this.legalPersonBeneficiary = legalPersonBeneficiary;
		
	}
    
}