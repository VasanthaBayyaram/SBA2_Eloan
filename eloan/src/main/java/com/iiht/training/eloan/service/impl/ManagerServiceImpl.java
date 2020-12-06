package com.iiht.training.eloan.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.ProcessingDto;
import com.iiht.training.eloan.dto.RejectDto;
import com.iiht.training.eloan.dto.SanctionDto;
import com.iiht.training.eloan.dto.SanctionOutputDto;
import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.dto.exception.LoansException;
import com.iiht.training.eloan.repository.LoanRepository;
import com.iiht.training.eloan.repository.ProcessingInfoRepository;
import com.iiht.training.eloan.repository.SanctionInfoRepository;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.ManagerService;
import com.iiht.training.eloan.util.LoansParser;

@Service
public class ManagerServiceImpl implements ManagerService {


	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private ProcessingInfoRepository pProcessingInfoRepository;
	
	@Autowired
	private SanctionInfoRepository sanctionInfoRepository;
	
	@Override
	public List<LoanOutputDto> allProcessedLoans()throws LoansException {
		
		List<LoanOutputDto> loanOutputdtos=new ArrayList<LoanOutputDto>();
		LoanOutputDto loanOutputTemp=new LoanOutputDto();
		UserDto userDtoTemp;
		ProcessingDto processDtoTemp;
		List<LoanDto> loanDtos=loanRepository.findAllByStatus(LoansParser.convert("processed")).stream().map(e->{
			try {
				return LoansParser.parse(e);
			} catch (LoansException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
		
		
		for(int i=0;i<loanDtos.size();i++)
		{
			if(LoansParser.convert(loanDtos.get(i).getStatus())==1)
			{
				userDtoTemp=LoansParser.parse(usersRepository.findById(loanDtos.get(i).getUserId()).get());
				loanDtos.get(i).setUser(userDtoTemp);
				processDtoTemp=LoansParser.parse((pProcessingInfoRepository.findByProcessLoan(LoansParser.parse(loanDtos.get(i)))));
				loanOutputTemp=new LoanOutputDto(loanDtos.get(i).getUserId(), loanDtos.get(i).getLoanId(), userDtoTemp, loanDtos.get(i), processDtoTemp, null, loanDtos.get(i).getStatus(), loanDtos.get(i).getRemark());
			}
			loanOutputdtos.add(loanOutputTemp);
		}
				return loanOutputdtos;
	}

	@Override
	public RejectDto rejectLoan(Long managerId, Long loanAppId, RejectDto rejectDto) throws LoansException {
		
		RejectDto rejectDtto=new RejectDto();
		
		if(!usersRepository.existsById(managerId))
		{
			throw new LoansException(managerId+" Manager id doesnot exist");
		}
		else if(!LoansParser.parse(usersRepository.findById(managerId).get()).getRole().trim().equalsIgnoreCase("manager"))
		{
			throw new LoansException("Invalid user role for the operation");
		}
		if(!loanRepository.existsById(loanAppId))
		{
			throw new LoansException(loanAppId+" Loan id does not exist");
		}
		if(!LoansParser.parse((loanRepository.findById(loanAppId).get())).getStatus().trim().equalsIgnoreCase("processed"))
		{
			throw new LoansException("Only Processed loans can be rejected");
		}
		
		LoanDto loanDto=LoansParser.parse(loanRepository.findById(loanAppId).get());
		loanDto.setUser(LoansParser.parse(usersRepository.findById(loanDto.getUserId()).get()));
		loanDto.setStatus("rejected");
		loanDto.setRemark(rejectDto.getRemark());
		loanRepository.save(LoansParser.parse(loanDto));
		rejectDtto.setRemark(rejectDto.getRemark());
		return rejectDtto;
	}

	@Override
	public SanctionOutputDto sanctionLoan(Long managerId, Long loanAppId, SanctionDto sanctionDto) throws LoansException {
		SanctionDto sDto=new SanctionDto();
		SanctionOutputDto soDto=new SanctionOutputDto();
		
		if(!usersRepository.existsById(managerId))
		{
			throw new LoansException(managerId+" Manager id doesnot exist");
		}
		else if(!LoansParser.parse(usersRepository.findById(managerId).get()).getRole().trim().equalsIgnoreCase("manager"))
		{
			throw new LoansException("Invalid user role for the operation");
		}
		if(!loanRepository.existsById(loanAppId))
		{
			throw new LoansException(loanAppId+" Loan id does not exist");
		}
		if(!LoansParser.parse((loanRepository.findById(loanAppId).get())).getStatus().trim().equalsIgnoreCase("processed"))
		{
			throw new LoansException(" Only Processed loans can be sanctioned");
		}
		
		LoanDto loanDto=LoansParser.parse(loanRepository.findById(loanAppId).get());
		loanDto.setUser(LoansParser.parse(usersRepository.findById(loanDto.getUserId()).get()));
		loanDto.setStatus("sanctioned");
		loanDto.setRemark(sanctionDto.getRemark());
		loanRepository.save(LoansParser.parse(loanDto));
		
		
		sDto.setLoanId(loanAppId);
		sDto.setLoanAmountSanctioned(sanctionDto.getLoanAmountSanctioned());		
		sDto.setPaymentStartDate(sanctionDto.getPaymentStartDate());
		sDto.setTermOfLoan(sanctionDto.getTermOfLoan());
		sDto.setManagerId(managerId);
		sDto.setLoanClosureDate(sanctionDto.getPaymentStartDate().plusYears(Math.round(sanctionDto.getTermOfLoan())));		
		sDto.setMonthlyPayment(Math.pow((sanctionDto.getLoanAmountSanctioned()*(1+12/100)), sanctionDto.getTermOfLoan()));
		sDto.setRemark(sanctionDto.getRemark());
		sDto.setsLoan(loanDto);
		
		soDto.setLoanAmountSanctioned(sanctionDto.getLoanAmountSanctioned());
		soDto.setLoanClosureDate(sanctionDto.getPaymentStartDate().plusYears(Math.round(sanctionDto.getTermOfLoan())));
		soDto.setLoanId(loanAppId);
		soDto.setMonthlyPayment(Math.pow((sanctionDto.getLoanAmountSanctioned()*(1+12/100)), sanctionDto.getTermOfLoan()));
		soDto.setPaymentStartDate(sanctionDto.getPaymentStartDate());
		soDto.setTermOfLoan(sanctionDto.getTermOfLoan());
		
		
		sanctionInfoRepository.save(LoansParser.parse(sDto));
		 return soDto;
		
	}
}