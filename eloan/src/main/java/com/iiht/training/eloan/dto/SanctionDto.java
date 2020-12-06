package com.iiht.training.eloan.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class SanctionDto {

	private Long loanId;

	@NotNull(message = "Sanctioned Loan Amount cannot be null")
	@Min(value = 1, message = "Sanctioned Loan Amount cannot be zero or negative")
	private Double loanAmountSanctioned;

	@NotNull(message = "Loan Term cannot be null")
	@Min(value = 1, message = "Loan Term cannot be zero or negative")
	private Double termOfLoan;

	@NotNull(message = "Payment start date cannot be null")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate paymentStartDate;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate loanClosureDate;

	@Min(value = 1, message = "Monthly Payment cannot be zero or negative")
	private Double monthlyPayment;

	@NotNull(message = "Remark cannot be null")
	private String remark;

	private Long managerId;

	private LoanDto sLoan;

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

	public Double getLoanAmountSanctioned() {
		return loanAmountSanctioned;
	}

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public LoanDto getsLoan() {
		return sLoan;
	}

	public void setsLoan(LoanDto sLoan) {
		this.sLoan = sLoan;
	}

	@Override
	public String toString() {
		return "SanctionDto [loanId=" + loanId + ", loanAmountSanctioned=" + loanAmountSanctioned + ", termOfLoan="
				+ termOfLoan + ", paymentStartDate=" + paymentStartDate + ", loanClosureDate=" + loanClosureDate
				+ ", monthlyPayment=" + monthlyPayment + ", remark=" + remark + ", managerId=" + managerId + ", sLoan="
				+ sLoan + "]";
	}

}
