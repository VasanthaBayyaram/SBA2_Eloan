package com.iiht.training.eloan.service;

import java.util.List;

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.dto.exception.LoansException;

public interface CustomerService {

	public UserDto register(UserDto userDto) throws LoansException;

	public LoanOutputDto applyLoan(Long customerId, LoanDto loanDto) throws LoansException;

	public LoanOutputDto getStatus(Long loanAppId) throws LoansException;

	public List<LoanOutputDto> getStatusAll(Long customerId) throws LoansException;

}
