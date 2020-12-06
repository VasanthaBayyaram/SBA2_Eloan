package com.iiht.training.eloan.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class ProcessingDto {

	@NotNull(message = "Acres of land cannot be null")
	@Min(value = 1, message = "Acres of land cannot be zero or negative")
	private Double acresOfLand;

	@NotNull(message = "Land value cannot be null")
	@Min(value = 1, message = "Land value cannot be zero or negative")
	private Double landValue;

	@NotNull(message = "Appraised By cannot be null")
	@NotBlank(message = "Appraised By cannot be blank")
	private String appraisedBy;

	@NotNull(message = "Loan Valuation date cannot be null")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate valuationDate;

	@NotNull(message = "Address of Property cannot be null")
	@NotBlank(message = "Address of Property cannot be blank")
	@Size(min = 3, max = 150, message = "Address of Property should range between 3 to 150 characters")
	private String addressOfProperty;

	@NotNull(message = "Suggested Amount of Loan cannot be null")
	@Min(value = 1, message = "Suggested Amount of Loan cannot be zero or negative")
	private Double suggestedAmountOfLoan;

	private Long loanId;

	private Long loanClerkId;

	private LoanDto loanDto;

	public ProcessingDto() {

	}

	public ProcessingDto(
			@NotNull(message = "Loan Id cannot be null") @NotBlank(message = "Loan Id cannot be blank") Long loanId,
			@NotNull(message = "Loan Clerk Id cannot be null") @NotBlank(message = "Loan Clerk Id cannot be blank") Long loanClerkId,
			@NotNull(message = "Acres of land cannot be null") @NotBlank(message = "Acres of land cannot be blank") @Min(value = 1, message = "Acres of land cannot be zero or negative") Double acresOfLand,
			@NotNull(message = "Land value cannot be null") @NotBlank(message = "Land value cannot be blank") @Min(value = 1, message = "Land value cannot be zero or negative") Double landValue,
			@NotNull(message = "Appraised By cannot be null") @NotBlank(message = "Appraised By cannot be blank") String appraisedBy,
			@NotNull(message = "Loan Valuation date cannot be null") @NotBlank(message = "Loan Valuation date cannot be blank") LocalDate valuationDate,
			@NotNull(message = "Address of Property cannot be null") @NotBlank(message = "Address of Property cannot be blank") @Size(min = 3, max = 150, message = "Address of Property should range between 3 to 150 characters") String addressOfProperty,
			@NotNull(message = "Suggested Amount of Loan cannot be null") @NotBlank(message = "Suggested Amount of Loan cannot be blank") @Min(value = 1, message = "Suggested Amount of Loan cannot be zero or negative") Double suggestedAmountOfLoan) {
		super();
		this.loanId = loanId;
		this.loanClerkId = loanClerkId;
		this.acresOfLand = acresOfLand;
		this.landValue = landValue;
		this.appraisedBy = appraisedBy;
		this.valuationDate = valuationDate;
		this.addressOfProperty = addressOfProperty;
		this.suggestedAmountOfLoan = suggestedAmountOfLoan;
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

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public Long getLoanClerkId() {
		return loanClerkId;
	}

	public void setLoanClerkId(Long loanClerkId) {
		this.loanClerkId = loanClerkId;
	}

	public LoanDto getLoanDto() {
		return loanDto;
	}

	public void setLoanDto(LoanDto loanDto) {
		this.loanDto = loanDto;
	}

	@Override
	public String toString() {
		return "ProcessingDto [acresOfLand=" + acresOfLand + ", landValue=" + landValue + ", appraisedBy=" + appraisedBy
				+ ", valuationDate=" + valuationDate + ", addressOfProperty=" + addressOfProperty
				+ ", suggestedAmountOfLoan=" + suggestedAmountOfLoan + ", loanId=" + loanId + ", loanClerkId="
				+ loanClerkId + ", loanDto=" + loanDto + "]";
	}

}
