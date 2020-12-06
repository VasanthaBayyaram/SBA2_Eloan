package com.iiht.training.eloan.service;

import java.util.List;

import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.RejectDto;
import com.iiht.training.eloan.dto.SanctionDto;
import com.iiht.training.eloan.dto.SanctionOutputDto;
import com.iiht.training.eloan.dto.exception.LoansException;

public interface ManagerService {
	public List<LoanOutputDto> allProcessedLoans() throws LoansException;

	public RejectDto rejectLoan(Long managerId, Long loanAppId, RejectDto rejectDto) throws LoansException;

	public SanctionOutputDto sanctionLoan(Long managerId, Long loanAppId, SanctionDto sanctionDto) throws LoansException;
}
