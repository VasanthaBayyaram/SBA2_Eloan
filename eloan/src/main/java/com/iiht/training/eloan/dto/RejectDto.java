package com.iiht.training.eloan.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RejectDto {

	@NotNull(message = "Remark cannot be null")
	@NotBlank(message = "Remark cannot be blank")
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public RejectDto() {
		super();

	}

	public RejectDto(
			@NotNull(message = "Remark cannot be null") @NotBlank(message = "Remark cannot be blank") String remark) {
		super();
		this.remark = remark;
	}

}
