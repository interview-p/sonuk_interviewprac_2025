package com.skt.educationApi.TransactionIsolationCheckAndLock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	   @Query(
	        value = "SELECT balance FROM account WHERE id = :id",
	        nativeQuery = true
	    )
	    Integer findBalanceById(@Param("id") Long id);
	   
	   //---------------pessimistic locking--------------
	   
	   @Lock(LockModeType.PESSIMISTIC_WRITE)
	   @QueryHints(@QueryHint(name = "jakarta.persistence.lock.timeout", value = "3000"))
	    @Query("SELECT a FROM Account a WHERE a.id = :id")
	    Account findByIdForUpdate(@Param("id") Long id);
	
}
