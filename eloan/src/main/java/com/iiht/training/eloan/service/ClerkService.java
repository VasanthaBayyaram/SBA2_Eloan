package com.iiht.training.eloan.service;

import java.util.List;

import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.ProcessingDto;
import com.iiht.training.eloan.dto.exception.LoansException;

public interface ClerkService {

	public List<LoanOutputDto> allAppliedLoans() throws LoansException;

	public ProcessingDto processLoan(Long clerkId, Long loanAppId, ProcessingDto processingDto) throws LoansException;
}