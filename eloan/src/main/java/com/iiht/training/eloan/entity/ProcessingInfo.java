package com.iiht.training.eloan.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loan_processing_info")
public class ProcessingInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "process_id")
	private Long processId;

	@Column(name = "clerk_id")
	private Long loanClerkId;

	@Column(name = "acres_of_land")
	private Double acresOfLand;

	@Column(name = "land_value")
	private Double landValue;

	@Column(name = "appraised_by")
	private String appraisedBy;

	@Column(name = "valuation_date")
	private LocalDate valuationDate;

	@Column(name = "property_address")
	private String addressOfProperty;

	@Column(name = "suggested_loan_amt")
	private Double suggestedAmountOfLoan;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "loan_id")
	private Loan processLoan;

	public ProcessingInfo() {

	}

	public ProcessingInfo(Long processId, Long loanClerkId, Double acresOfLand, Double landValue, String appraisedBy,
			LocalDate valuationDate, String addressOfProperty, Double suggestedAmountOfLoan, Loan processLoan) {
		super();
		this.processId = processId;
		this.loanClerkId = loanClerkId;
		this.acresOfLand = acresOfLand;
		this.landValue = landValue;
		this.appraisedBy = appraisedBy;
		this.valuationDate = valuationDate;
		this.addressOfProperty = addressOfProperty;
		this.suggestedAmountOfLoan = suggestedAmountOfLoan;
		this.processLoan = processLoan;
	}

	public Long getProcessId() {
		return processId;
	}

	public void setProcessId(Long processId) {
		this.processId = processId;
	}

	public Long getLoanClerkId() {
		return loanClerkId;
	}

	public void setLoanClerkId(Long loanClerkId) {
		this.loanClerkId = loanClerkId;
	}

	public Double getAcresOfLand() {
		return acresOfLand;
	}

	public void setAcresOfLand(Double acresOfLand) {
		this.acresOfLand = acresOfLand;
	}

	public Double getLandValue() {
		return landValue;
	}

	public void setLandValue(Double landValue) {
		this.landValue = landValue;
	}

	public String getAppraisedBy() {
		return appraisedBy;
	}

	public void setAppraisedBy(String appraisedBy) {
		this.appraisedBy = appraisedBy;
	}

	public LocalDate getValuationDate() {
		return valuationDate;
	}

	public void setValuationDate(LocalDate valuationDate) {
		this.valuationDate = valuationDate;
	}

	public String getAddressOfProperty() {
		return addressOfProperty;
	}

	public void setAddressOfProperty(String addressOfProperty) {
		this.addressOfProperty = addressOfProperty;
	}

	public Double getSuggestedAmountOfLoan() {
		return suggestedAmountOfLoan;
	}

	public void setSuggestedAmountOfLoan(Double suggestedAmountOfLoan) {
		this.suggestedAmountOfLoan = suggestedAmountOfLoan;
	}

	public Loan getLoan() {
		return processLoan;
	}

	public void setLoan(Loan processLoan) {
		this.processLoan = processLoan;
	}

	@Override
	public String toString() {
		return "ProcessingInfo [processId=" + processId + ", loanClerkId=" + loanClerkId + ", acresOfLand="
				+ acresOfLand + ", landValue=" + landValue + ", appraisedBy=" + appraisedBy + ", valuationDate="
				+ valuationDate + ", addressOfProperty=" + addressOfProperty + ", suggestedAmountOfLoan="
				+ suggestedAmountOfLoan + ", processLoan=" + processLoan + "]";
	}

}
