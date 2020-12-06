package com.iiht.training.eloan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.training.eloan.entity.Loan;
import com.iiht.training.eloan.entity.Users;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

	List<Loan> findAllByUser(Users user);

	List<Loan> findAllByStatus(int status);
	
}
