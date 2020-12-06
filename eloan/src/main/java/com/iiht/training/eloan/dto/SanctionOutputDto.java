package com.iiht.training.eloan.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class SanctionOutputDto {

	private Long loanId;

	@NotNull(message = "Sanctioned Loan Amount cannot be null")
	@NotBlank(message = "Sanctioned Loan Amount cannot be blank")
	@Min(value = 1, message = "Sanctioned Loan Amount cannot be zero or negative")
	private Double loanAmountSanctioned;

	@NotNull(message = "Loan Term cannot be null")
	@NotBlank(message = "Loan Term cannot be blank")
	private Double termOfLoan;

	@NotNull(message = "Payment start date cannot be null")
	@NotBlank(message = "Payment start date cannot be blank")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate paymentStartDate;

	@NotNull(message = "Loan Closure date cannot be null")
	@NotBlank(message = "Loan Closure date cannot be blank")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate loanClosureDate;

	@NotNull(message = "Emi cannot be null")
	@NotBlank(message = "Emi cannot be blank")
	@Min(value = 1, message = "Emi cannot be zero or negative")
	private Double monthlyPayment;

	public SanctionOutputDto() {

	}

	public SanctionOutputDto(Long loanId,
			@NotNull(message = "Sanctioned Loan Amount cannot be null") @NotBlank(message = "Sanctioned Loan Amount cannot be blank") @Min(value = 1, message = "Sanctioned Loan Amount cannot be zero or negative") Double loanAmountSanctioned,
			@NotNull(message = "Loan Term cannot be null") @NotBlank(message = "Loan Term cannot be blank") Double termOfLoan,
			@NotNull(message = "Payment start date cannot be null") @NotBlank(message = "Payment start date cannot be blank") LocalDate paymentStartDate,
			@NotNull(message = "Loan Closure date cannot be null") @NotBlank(message = "Loan Closure date cannot be blank") LocalDate loanClosureDate,
			@NotNull(message = "Emi cannot be null") @NotBlank(message = "Emi cannot be blank") @Min(value = 1, message = "Emi cannot be zero or negative") Double monthlyPayment) {
		super();
		this.loanId = loanId;
		this.loanAmountSanctioned = loanAmountSanctioned;
		this.termOfLoan = termOfLoan;
		this.paymentStartDate = paymentStartDate;
		this.loanClosureDate = loanClosureDate;
		this.monthlyPayment = monthlyPayment;
	}

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
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

	@Override
	public String toString() {
		return "SanctionOutputDto [loanId=" + loanId + ", loanAmountSanctioned=" + loanAmountSanctioned
				+ ", termOfLoan=" + termOfLoan + ", paymentStartDate=" + paymentStartDate + ", loanClosureDate="
				+ loanClosureDate + ", monthlyPayment=" + monthlyPayment + "]";
	}

}
