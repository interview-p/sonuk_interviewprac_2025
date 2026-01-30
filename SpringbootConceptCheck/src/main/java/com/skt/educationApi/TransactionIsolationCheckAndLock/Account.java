package com.skt.educationApi.TransactionIsolationCheckAndLock;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Account {

	@Id
	//@GeneratedValue
    private Long id;

    private int balance;
    
    private String status;
    
    @Version
    private Long version;   // ⭐ OPTIMISTIC LOCK

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Account() {
		super();
	}

	public Account(Long id, int balance, String status) {
		super();
		this.id = id;
		this.balance = balance;
		this.status = status;
	}
	
	
	
	
	
	
    
    
}
