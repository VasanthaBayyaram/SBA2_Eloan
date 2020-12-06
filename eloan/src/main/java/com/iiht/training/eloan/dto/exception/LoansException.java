package com.iiht.training.eloan.dto.exception;

import java.util.List;

import org.springframework.validation.ObjectError;

public class LoansException extends Exception{
	
	public LoansException(String msg) {
		super(msg);
	}
	public static void toErrExceptions(List<ObjectError> allErrors) throws LoansException
	{
		StringBuilder sb=new StringBuilder();
		for(ObjectError err:allErrors)
		{
			sb.append(err.getDefaultMessage()+",");
		}
		String s=sb.toString();
		throw new LoansException(s);
	}

}
