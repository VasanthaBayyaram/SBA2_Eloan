package com.iiht.training.eloan.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.dto.exception.LoansException;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.AdminService;
import com.iiht.training.eloan.util.LoansParser;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private UsersRepository usersRepository;
	
	@Transactional
	@Override
	public UserDto registerClerk(UserDto userDto) throws LoansException {
		// TODO Auto-generated method stub
		if(userDto!=null) {
			
		if(!userDto.getRole().trim().equals("clerk")) {
				throw new LoansException("Error registering User as Clerk, given role is incorrect. Expected- clerk");
				
			}
			
			userDto=LoansParser.parse(usersRepository.save(LoansParser.parse(userDto)));
						
		
		}
		return userDto;
	}

	@Transactional
	@Override
	public UserDto registerManager(UserDto userDto) throws LoansException {
		if(userDto!=null) {
			
			if(!userDto.getRole().trim().equals("manager")) {
				throw new LoansException("Error registering User as Manager, given role is incorrect. Expected- manager");
				
			}
			userDto=LoansParser.parse(usersRepository.save(LoansParser.parse(userDto)));
						
		}
		
		return userDto;
	}

	@Override
	public List<UserDto> getAllClerks() {
		return usersRepository.findAllByRole("clerk").stream().map(e-> LoansParser.parse(e)).collect(Collectors.toList());
	}

	@Override
	public List<UserDto> getAllManagers() {
		// TODO Auto-generated method stub
		return usersRepository.findAllByRole("manager").stream().map(e-> LoansParser.parse(e)).collect(Collectors.toList());
	}

}
