package com.iiht.training.eloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iiht.training.eloan.entity.Loan;
import com.iiht.training.eloan.entity.SanctionInfo;

@Repository
public interface SanctionInfoRepository extends JpaRepository<SanctionInfo, Long> {

	SanctionInfo findBySanctionLoan(Loan loan);

	@Modifying
	@Query("UPDATE SanctionInfo si SET monthlyPayment=500 WHERE si.sanctionLoan = :loanId ")
	void updateCalculatedValues(@Param("loanId") Long loanId);

}
