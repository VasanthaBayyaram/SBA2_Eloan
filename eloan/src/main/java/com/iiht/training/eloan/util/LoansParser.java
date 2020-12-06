package com.iiht.training.eloan.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.ProcessingDto;
import com.iiht.training.eloan.dto.RejectDto;
import com.iiht.training.eloan.dto.SanctionDto;
import com.iiht.training.eloan.dto.SanctionOutputDto;
import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.dto.exception.LoansException;
import com.iiht.training.eloan.entity.Loan;
import com.iiht.training.eloan.entity.ProcessingInfo;
import com.iiht.training.eloan.entity.SanctionInfo;
import com.iiht.training.eloan.entity.Users;
import com.iiht.training.eloan.service.ClerkService;

public class LoansParser {
	@Autowired
	private ClerkService clerkService;

	public static UserDto parse(Users source) {

		UserDto user = new UserDto();

		user.setUserId(source.getUserId());
		user.setMobile(source.getMobile());
		user.setFirstName(source.getFirstName());
		user.setLastName(source.getLastName());
		user.setEmail(source.getEmail());
		user.setRole(source.getRole());
		return user;
	}

	public static Users parse(UserDto source) {
		Users target = new Users();

		target.setUserId(source.getUserId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setMobile(source.getMobile());
		target.setRole(source.getRole());
		target.setEmail(source.getEmail());
		return target;
	}

	public static LoanDto parse(Loan source) throws LoansException {

		LoanDto target = new LoanDto();
		target.setLoanId(source.getLoanId());
		target.setLoanName(source.getLoanName());
		target.setBillingIndicator(source.getBillingIndicator());
		target.setBusinessStructure(source.getBusinessStructure());
		target.setLoanApplicationDate(source.getLoanApplicationDate());
		target.setLoanAmount(source.getLoanAmount());
		target.setTaxIndicator(source.getTaxIndicator());
		target.setUserId(source.getUser().getUserId());
		target.setStatus(LoansParser.convert(source.getStatus()));
		target.setRemark(source.getRemark());

		return target;
	}

	public static Loan parse(LoanDto source) throws LoansException {
		Loan target = new Loan();
		target.setLoanId(source.getLoanId());
		target.setLoanName(source.getLoanName());
		target.setBillingIndicator(source.getBillingIndicator());
		target.setBusinessStructure(source.getBusinessStructure());
		target.setLoanApplicationDate(source.getLoanApplicationDate());
		target.setLoanAmount(source.getLoanAmount());
		target.setTaxIndicator(source.getTaxIndicator());
		target.setStatus(LoansParser.convert(source.getStatus()));
		target.setUser(LoansParser.parse(source.getUser()));
		target.setRemark(source.getRemark());
		return target;
	}

	public static ProcessingInfo parse(ProcessingDto source) throws LoansException {

		ProcessingInfo target = new ProcessingInfo();
		target.setAcresOfLand(source.getAcresOfLand());
		target.setAddressOfProperty(source.getAddressOfProperty());
		target.setAppraisedBy(source.getAppraisedBy());
		target.setLandValue(source.getLandValue());
		target.setValuationDate(source.getValuationDate());
		target.setSuggestedAmountOfLoan(source.getSuggestedAmountOfLoan());
		target.setLoanClerkId(source.getLoanClerkId());
		target.setLoan(LoansParser.parse(source.getLoanDto()));
		return target;

	}

	public static ProcessingDto parse(ProcessingInfo source) throws LoansException {

		ProcessingDto target = new ProcessingDto();
		target.setAcresOfLand(source.getAcresOfLand());
		target.setAddressOfProperty(source.getAddressOfProperty());
		target.setAppraisedBy(source.getAppraisedBy());
		target.setLandValue(source.getLandValue());
		target.setValuationDate(source.getValuationDate());
		target.setSuggestedAmountOfLoan(source.getSuggestedAmountOfLoan());
		target.setLoanId(source.getLoan().getLoanId());
		target.setLoanClerkId(source.getLoanClerkId());
		target.setLoanDto(LoansParser.parse(source.getLoan()));
		return target;

	}

	public static SanctionDto parse(SanctionInfo source) {

		SanctionDto target = new SanctionDto();
		target.setLoanAmountSanctioned(source.getLoanAmountSanctioned());
		target.setPaymentStartDate(source.getPaymentStartDate());
		target.setTermOfLoan(source.getTermOfLoan());
		return target;

	}

	public static SanctionInfo parse(SanctionDto source) throws LoansException {

		SanctionInfo target = new SanctionInfo();
		target.setLoanAmountSanctioned(source.getLoanAmountSanctioned());
		target.setPaymentStartDate(source.getPaymentStartDate());
		target.setTermOfLoan(source.getTermOfLoan());
		target.setLoanClosureDate(source.getLoanClosureDate());
		target.setManagerId(source.getManagerId());
		target.setMonthlyPayment(source.getMonthlyPayment());
		target.setSanctionLoan(LoansParser.parse(source.getsLoan()));
		return target;

	}

	public static SanctionOutputDto parse1(SanctionInfo source) {

		SanctionOutputDto target = new SanctionOutputDto();
		target.setLoanClosureDate(source.getLoanClosureDate());
		target.setLoanAmountSanctioned(source.getLoanAmountSanctioned());
		target.setPaymentStartDate(source.getPaymentStartDate());
		target.setTermOfLoan(source.getTermOfLoan());
		target.setMonthlyPayment(source.getMonthlyPayment());
		target.setLoanId(source.getSanctionLoan().getLoanId());

		return target;

	}

	public static SanctionInfo parse1(SanctionOutputDto source) {

		SanctionInfo target = new SanctionInfo();
		target.setLoanClosureDate(source.getLoanClosureDate());
		target.setLoanAmountSanctioned(source.getLoanAmountSanctioned());
		target.setPaymentStartDate(source.getPaymentStartDate());
		target.setTermOfLoan(source.getTermOfLoan());
		target.setMonthlyPayment(source.getMonthlyPayment());
		target.getSanctionLoan().setLoanId(source.getLoanId());

		return target;

	}

	public static LoanOutputDto parse1(Loan source) throws LoansException {

		LoanOutputDto target = new LoanOutputDto();
		target.setRemark(source.getRemark());
		target.setStatus(convert(source.getStatus()));
		return target;

	}

	public static Loan parse1(LoanOutputDto source) throws LoansException {

		Loan target = new Loan();
		target.setRemark(source.getRemark());
		target.setStatus(convert(source.getStatus()));
		return target;

	}

	public static RejectDto parse2(Loan source) {

		RejectDto target = new RejectDto();
		target.setRemark(source.getRemark());

		return target;

	}

	public static Loan parse2(RejectDto source) {

		Loan target = new Loan();
		target.setRemark(source.getRemark());

		return target;

	}

	public static String convert(int code) throws LoansException {
		String status = "";

		switch (code) {
		case 0:
			status = "applied";
			break;
		case 1:
			status = "processed";
			break;
		case 2:
			status = "sanctioned";
			break;
		case -1:
			status = "rejected";
			break;
		default:
			throw new LoansException(code + " code is invalid");
		}
		return status;

	}

	public static int convert(String status) throws LoansException {
		int code = -10;

		switch (status.toLowerCase()) {
		case "applied":
			code = 0;
			break;
		case "processed":
			code = 1;
			break;
		case "sanctioned":
			code = 2;
			break;
		case "rejected":
			code = -1;
			break;
		default:
			throw new LoansException(status + " status is invalid");

		}
		return code;

	}

}
