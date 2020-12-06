package com.iiht.training.eloan.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.iiht.training.eloan.entity.Users;

public class LoanDto {

	@NotNull(message = "Loan name cannot be null")
	@NotBlank(message = "Loan name cannot be blank")
	@Size(min = 3, max = 100, message = "Loan name should range between 3 to 100 characters")
	private String loanName;

	@NotNull(message = "Loan Amount cannot be null")
	@Min(value = 1, message = "Loan Amount cannot be zero or negative")
	private Double loanAmount;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate loanApplicationDate;

	@NotNull(message = "Business structure cannot be null")
	@NotBlank(message = "Business structure cannot be blank")
	private String businessStructure;

	@NotNull(message = "Billing Indicator cannot be null")
	@NotBlank(message = "Billing Indicator cannot be blank")
	private String billingIndicator;

	@NotNull(message = "Tax indicator cannot be null")
	@NotBlank(message = "Tax indicator cannot be blank")
	private String taxIndicator;

	private String status;

	private Long userId;

	private String remark;
	
	private Long loanId;

	private UserDto userDto;

	public LoanDto() {

	}

	public LoanDto(Long loanId, Users user,
			@NotNull(message = "Loan name cannot be null") @NotBlank(message = "Loan name cannot be blank") @Size(min = 3, max = 100, message = "Loan name should range between 3 to 100 characters") String loanName,
			@NotNull(message = "Loan Amount cannot be null") @Min(value = 1, message = "Loan Amount cannot be zero or negative") Double loanAmount,
			LocalDate loanApplicationDate,
			@NotNull(message = "Business structure cannot be null") @NotBlank(message = "Business structure cannot be blank") String businessStructure,
			@NotNull(message = "Billing Indicator cannot be null") @NotBlank(message = "Billing Indicator cannot be blank") String billingIndicator,
			@NotNull(message = "Tax indicator cannot be null") @NotBlank(message = "Tax indicator cannot be blank") String taxIndicator,
			String status, Long userId, String remark) {
		super();
		this.loanId = loanId;
		this.loanName = loanName;
		this.loanAmount = loanAmount;
		this.loanApplicationDate = loanApplicationDate;
		this.businessStructure = businessStructure;
		this.billingIndicator = billingIndicator;
		this.taxIndicator = taxIndicator;
		this.status = status;
		this.userId = userId;
		this.remark = remark;
	}

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public UserDto getUser() {
		return userDto;
	}

	public void setUser(UserDto userDto) {
		this.userDto = userDto;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "LoanDto [loanId=" + loanId + ", userDto=" + userDto + ", loanName=" + loanName + ", loanAmount="
				+ loanAmount + ", loanApplicationDate=" + loanApplicationDate + ", businessStructure="
				+ businessStructure + ", billingIndicator=" + billingIndicator + ", taxIndicator=" + taxIndicator
				+ ", status=" + status + ", userId=" + userId + ", remark=" + remark + "]";
	}

}
