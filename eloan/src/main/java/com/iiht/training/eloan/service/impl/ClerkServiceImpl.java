package com.iiht.training.eloan.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.ProcessingDto;
import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.dto.exception.LoansException;
import com.iiht.training.eloan.repository.LoanRepository;
import com.iiht.training.eloan.repository.ProcessingInfoRepository;
import com.iiht.training.eloan.repository.SanctionInfoRepository;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.ClerkService;
import com.iiht.training.eloan.util.LoansParser;

@Service
public class ClerkServiceImpl implements ClerkService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private ProcessingInfoRepository processingInfoRepository;
	
	@Autowired
	private SanctionInfoRepository sanctionInfoRepository;
	
	@Override
	public List<LoanOutputDto> allAppliedLoans() throws LoansException {
		List<LoanOutputDto> loanOutputdtos=new ArrayList<LoanOutputDto>();
		LoanOutputDto loanOutputTemp=new LoanOutputDto();
		UserDto userDtoTemp;
		List<LoanDto> loanDtos=loanRepository.findAllByStatus(LoansParser.convert("applied")).stream().map(e->{
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
			if(LoansParser.convert(loanDtos.get(i).getStatus())==0)
			{
				userDtoTemp=LoansParser.parse(usersRepository.findById(loanDtos.get(i).getUserId()).get());
				loanOutputTemp=new LoanOutputDto(loanDtos.get(i).getUserId(), loanDtos.get(i).getLoanId(), userDtoTemp, loanDtos.get(i), null, null, loanDtos.get(i).getStatus(), loanDtos.get(i).getRemark());
			}
			loanOutputdtos.add(loanOutputTemp);
		}
				return loanOutputdtos;
	}

	@Override
	public ProcessingDto processLoan(Long clerkId, Long loanAppId, ProcessingDto processingDto) throws LoansException {
		ProcessingDto processDtoTemp=new ProcessingDto();
		
		if(!usersRepository.existsById(clerkId))
		{
			throw new LoansException(clerkId+" Clerk id doesnot exist");
		}
		else if(!LoansParser.parse(usersRepository.findById(clerkId).get()).getRole().trim().equalsIgnoreCase("clerk"))
		{
			throw new LoansException("Invalid user role for the operation");
		}
		if(!loanRepository.existsById(loanAppId))
		{
			throw new LoansException(loanAppId+" Loan id does not exist");
		}
		if(!LoansParser.parse((loanRepository.findById(loanAppId).get())).getStatus().trim().equalsIgnoreCase("applied"))
		{
			throw new LoansException(" Loan status other than applied cannot be processed");
		}
		LoanDto loanDto=LoansParser.parse(loanRepository.findById(loanAppId).get());
		loanDto.setUser(LoansParser.parse(usersRepository.findById(loanDto.getUserId()).get()));
		loanDto.setStatus("processed");
		
		processDtoTemp.setLoanId(loanAppId);
		processDtoTemp.setLoanDto(loanDto);
		processDtoTemp.setLoanClerkId(clerkId);
		processDtoTemp.setAcresOfLand(processingDto.getAcresOfLand());
		processDtoTemp.setAddressOfProperty(processingDto.getAddressOfProperty());
		processDtoTemp.setAppraisedBy(processingDto.getAppraisedBy());
		processDtoTemp.setLandValue(processingDto.getLandValue());
		processDtoTemp.setSuggestedAmountOfLoan(processingDto.getSuggestedAmountOfLoan());
		processDtoTemp.setValuationDate(processingDto.getValuationDate());
			
		processingInfoRepository.save((LoansParser.parse(processDtoTemp)));
		loanRepository.save(LoansParser.parse(loanDto));
		
		return processDtoTemp;
	} 

}
