package com.iiht.training.eloan.service;

import java.util.List;

import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.dto.exception.LoansException;

public interface AdminService {

	public UserDto registerClerk(UserDto userDto)throws LoansException;
	
	public UserDto registerManager(UserDto userDto)throws LoansException;
	
	public List<UserDto> getAllClerks()throws LoansException;
		
	public List<UserDto> getAllManagers()throws LoansException;
	
	
}
