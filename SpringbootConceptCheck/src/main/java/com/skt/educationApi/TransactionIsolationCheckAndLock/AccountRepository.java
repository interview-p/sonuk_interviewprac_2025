package com.skt.educationApi.TransactionIsolationCheck;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	   @Query(
	        value = "SELECT balance FROM account WHERE id = :id",
	        nativeQuery = true
	    )
	    Integer findBalanceById(@Param("id") Long id);
	
}
