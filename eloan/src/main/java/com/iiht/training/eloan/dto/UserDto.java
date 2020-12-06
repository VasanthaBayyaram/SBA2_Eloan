package com.iiht.training.eloan.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {

	private Long userId;

	@NotNull(message = "First Name cannot be null")
	@NotBlank(message = "First Name cannot be blank")
	@Size(min = 3, max = 100, message = "First Name should range between 3 to 100 characters")
	private String firstName;

	@NotNull(message = "Last Name cannot be null")
	@NotBlank(message = "Last Name cannot be blank")
	@Size(min = 3, max = 100, message = "Last Name should range between 3 to 100 characters")
	private String lastName;

	@NotNull(message = "Email cannot be null")
	@NotBlank(message = "Email cannot be blank")
	@Size(min = 3, max = 100, message = "Email should range between 3 to 100 characters")
	@Email(message = "Email format should be correct")
	private String email;

	@NotNull(message = "Mobile cannot be null")
	@NotBlank(message = "Mobile cannot be blank")
	@Size(min = 10, max = 10, message = "Mobile should be 10 digits only")
	private String mobile;

	@NotNull(message = "Role cannot be null")
	@NotBlank(message = "Role cannot be blank")
	@Size(min = 3, max = 100, message = "Role name should range between 3 to 100 characters")
	private String role;

	// private Set<Loan> loans;

	public UserDto() {

	}

	public UserDto(Long userId,
			@NotNull(message = "First Name cannot be null") @NotBlank(message = "First Name cannot be blank") @Size(min = 3, max = 100, message = "First Name should range between 3 to 100 characters") String firstName,
			@NotNull(message = "Last Name cannot be null") @NotBlank(message = "Last Name cannot be blank") @Size(min = 3, max = 100, message = "Last Name should range between 3 to 100 characters") String lastName,
			@NotNull(message = "Email cannot be null") @NotBlank(message = "Email cannot be blank") @Size(min = 3, max = 100, message = "Email should range between 3 to 100 characters") @Email(message = "Email format should be correct") String email,
			@NotNull(message = "Mobile cannot be null") @NotBlank(message = "Mobile cannot be blank") @Size(min = 10, max = 10, message = "Mobile should be 10 digits only") String mobile,
			@NotNull(message = "Role cannot be null") @NotBlank(message = "Role cannot be blank") @Size(min = 3, max = 100, message = "Role name should range between 3 to 100 characters") String role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobile=" + mobile + ", role=" + role + "]";
	}

}
