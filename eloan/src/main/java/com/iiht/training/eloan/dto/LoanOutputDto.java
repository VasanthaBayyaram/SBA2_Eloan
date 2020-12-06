package com.iiht.training.eloan.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoanOutputDto {
	
	@NotNull(message = "Customer Id cannot be null")
	@NotBlank(message = "Customer Id cannot be blank")
	private Long customerId;

	@NotNull(message = "Loan Application Id cannot be null")
	@NotBlank(message = "Loan Application Id cannot be blank")
	private Long loanAppId;

	@NotNull(message = "User info cannot be null")
	private UserDto userDto;

	@NotNull(message = "Loan info cannot be null")
	private LoanDto loanDto;

	@NotNull(message = "Loan Processing info cannot be null")
	private ProcessingDto processingDto;

	@NotNull(message = "Loan Sanction info cannot be null")
	private SanctionOutputDto sanctionOutputDto;

	@NotNull(message = "Status cannot be null")
	@NotBlank(message = "Status cannot be blank")
	private String status;

	@NotNull(message = "Remark cannot be null")
	@NotBlank(message = "Remark cannot be blank")
	private String remark;

	public LoanOutputDto() {

	}

	public LoanOutputDto(
			@NotNull(message = "Customer Id cannot be null") @NotBlank(message = "Customer Id cannot be blank") Long customerId,
			@NotNull(message = "Loan Application Id cannot be null") @NotBlank(message = "Loan Application Id cannot be blank") Long loanAppId,
			@NotNull(message = "User info cannot be null") UserDto userDto,
			@NotNull(message = "Loan info cannot be null") LoanDto loanDto,
			@NotNull(message = "Loan Processing info cannot be null") ProcessingDto processingDto,
			@NotNull(message = "Loan Sanction info cannot be null") SanctionOutputDto sanctionOutputDto,
			@NotNull(message = "Status cannot be null") @NotBlank(message = "Status cannot be blank") String status,
			@NotNull(message = "Remark cannot be null") @NotBlank(message = "Remark cannot be blank") String remark) {
		super();
		this.customerId = customerId;
		this.loanAppId = loanAppId;
		this.userDto = userDto;
		this.loanDto = loanDto;
		this.processingDto = processingDto;
		this.sanctionOutputDto = sanctionOutputDto;
		this.status = status;
		this.remark = remark;
	}

	public LoanOutputDto(Long customerId, Long loanAppId, UserDto userDto, LoanDto loanDto, String status) {
		this.customerId = customerId;
		this.loanAppId = loanAppId;
		this.userDto = userDto;
		this.loanDto = loanDto;
		this.status = status;

	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getLoanAppId() {
		return loanAppId;
	}

	public void setLoanAppId(Long loanAppId) {
		this.loanAppId = loanAppId;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public LoanDto getLoanDto() {
		return loanDto;
	}

	public void setLoanDto(LoanDto loanDto) {
		this.loanDto = loanDto;
	}

	public ProcessingDto getProcessingDto() {
		return processingDto;
	}

	public void setProcessingDto(ProcessingDto processingDto) {
		this.processingDto = processingDto;
	}

	public SanctionOutputDto getSanctionOutputDto() {
		return sanctionOutputDto;
	}

	public void setSanctionOutputDto(SanctionOutputDto sanctionOutputDto) {
		this.sanctionOutputDto = sanctionOutputDto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "LoanOutputDto [customerId=" + customerId + ", loanAppId=" + loanAppId + ", userDto=" + userDto
				+ ", loanDto=" + loanDto + ", processingDto=" + processingDto + ", sanctionOutputDto="
				+ sanctionOutputDto + ", status=" + status + ", remark=" + remark + "]";
	}

}
