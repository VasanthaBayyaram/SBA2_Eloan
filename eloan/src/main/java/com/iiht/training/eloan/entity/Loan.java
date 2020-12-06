package com.iiht.training.eloan.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loans")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_id")
	private Long loanId;

	@Column(name = "loan_name", nullable = false)
	private String loanName;

	@Column(name = "loan_amount")
	private Double loanAmount;

	@Column(name = "loan_app_date")
	private LocalDate loanApplicationDate;

	@Column(name = "business_str")
	private String businessStructure;

	@Column(name = "billing_ind")
	private String billingIndicator;

	@Column(name = "tax_ind")
	private String taxIndicator;

	@Column(name = "loan_status")
	private Integer status;

	@Column(name = "remark")
	private String remark;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id")
	private Users user;

	@OneToOne(mappedBy = "processLoan")
	private ProcessingInfo processLoan;

	@OneToOne(mappedBy = "sanctionLoan")
	private SanctionInfo loan;

	public Loan() {

	}

	public Loan(Long loanId, String loanName, Double loanAmount, LocalDate loanApplicationDate,
			String businessStructure, String billingIndicator, String taxIndicator, Integer status, String remark,
			Users user) {
		super();
		this.loanId = loanId;
		this.loanName = loanName;
		this.loanAmount = loanAmount;
		this.loanApplicationDate = loanApplicationDate;
		this.businessStructure = businessStructure;
		this.billingIndicator = billingIndicator;
		this.taxIndicator = taxIndicator;
		this.status = status;
		this.remark = remark;
		this.user = user;
	}

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public String getLoanName() {
		return loanName;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public LocalDate getLoanApplicationDate() {
		return loanApplicationDate;
	}

	public void setLoanApplicationDate(LocalDate loanApplicationDate) {
		this.loanApplicationDate = loanApplicationDate;
	}

	public String getBusinessStructure() {
		return businessStructure;
	}

	public void setBusinessStructure(String businessStructure) {
		this.businessStructure = businessStructure;
	}

	public String getBillingIndicator() {
		return billingIndicator;
	}

	public void setBillingIndicator(String billingIndicator) {
		this.billingIndicator = billingIndicator;
	}

	public String getTaxIndicator() {
		return taxIndicator;
	}

	public void setTaxIndicator(String taxIndicator) {
		this.taxIndicator = taxIndicator;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanName=" + loanName + ", loanAmount=" + loanAmount
				+ ", loanApplicationDate=" + loanApplicationDate + ", businessStructure=" + businessStructure
				+ ", billingIndicator=" + billingIndicator + ", taxIndicator=" + taxIndicator + ", status=" + status
				+ ", remark=" + remark + ", user=" + user + ", processLoan=" + processLoan + ", loan=" + loan + "]";
	}

}
