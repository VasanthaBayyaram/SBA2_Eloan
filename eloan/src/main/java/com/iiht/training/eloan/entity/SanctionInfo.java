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
@Table(name = "loan_sanction_info")
public class SanctionInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sanction_id")
	private Long sanctionId;

	@Column(name = "manager_id")
	private Long managerId;

	@Column(name = "sanctioned_amount")
	private Double loanAmountSanctioned;

	@Column(name = "loan_term")
	private Double termOfLoan;

	@Column(name = "payment_start_dte")
	private LocalDate paymentStartDate;

	@Column(name = "loan_closure_dte")
	private LocalDate loanClosureDate;

	@Column(name = "emi")
	private Double monthlyPayment;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "loan_id")
	private Loan sanctionLoan;

	public SanctionInfo(Long sanctionId, Long managerId, Double loanAmountSanctioned, Double termOfLoan,
			LocalDate paymentStartDate, LocalDate loanClosureDate, Double monthlyPayment, Loan sanctionLoan) {
		super();
		this.sanctionId = sanctionId;
		this.managerId = managerId;
		this.loanAmountSanctioned = loanAmountSanctioned;
		this.termOfLoan = termOfLoan;
		this.paymentStartDate = paymentStartDate;
		this.loanClosureDate = loanClosureDate;
		this.monthlyPayment = monthlyPayment;
		this.sanctionLoan = sanctionLoan;
	}

	public SanctionInfo() {
		// TODO Auto-generated constructor stub
	}

	public Long getSanctionId() {
		return sanctionId;
	}

	public void setSanctionId(Long sanctionId) {
		this.sanctionId = sanctionId;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Double getLoanAmountSanctioned() {
		return loanAmountSanctioned;
	}

	public void setLoanAmountSanctioned(Double loanAmountSanctioned) {
		this.loanAmountSanctioned = loanAmountSanctioned;
	}

	public Double getTermOfLoan() {
		return termOfLoan;
	}

	public void setTermOfLoan(Double termOfLoan) {
		this.termOfLoan = termOfLoan;
	}

	public LocalDate getPaymentStartDate() {
		return paymentStartDate;
	}

	public void setPaymentStartDate(LocalDate paymentStartDate) {
		this.paymentStartDate = paymentStartDate;
	}

	public LocalDate getLoanClosureDate() {
		return loanClosureDate;
	}

	public void setLoanClosureDate(LocalDate loanClosureDate) {
		this.loanClosureDate = loanClosureDate;
	}

	public Double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(Double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public Loan getSanctionLoan() {
		return sanctionLoan;
	}

	public void setSanctionLoan(Loan sanctionLoan) {
		this.sanctionLoan = sanctionLoan;
	}

	@Override
	public String toString() {
		return "SanctionInfo [sanctionId=" + sanctionId + ", managerId=" + managerId + ", loanAmountSanctioned="
				+ loanAmountSanctioned + ", termOfLoan=" + termOfLoan + ", paymentStartDate=" + paymentStartDate
				+ ", loanClosureDate=" + loanClosureDate + ", monthlyPayment=" + monthlyPayment + ", sanctionLoan="
				+ sanctionLoan + "]";
	}

}
