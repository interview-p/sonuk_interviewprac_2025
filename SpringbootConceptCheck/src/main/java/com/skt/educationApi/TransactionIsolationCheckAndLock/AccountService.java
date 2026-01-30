package com.skt.educationApi.TransactionIsolationCheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AccountService {

	@Autowired
	AccountRepository repo;
	
	@Transactional   // default = READ_COMMITTED
    public void checkBalance(Long id) throws Exception {
        Account a1 = repo.findById(id).get();
        System.out.println("First read: " + a1.getBalance());

        Thread.sleep(5000); // simulate long processing

        Account a2 = repo.findById(id).get();
        System.out.println("Second read: " + a2.getBalance());
    }
	
	@Transactional
	public void updateBalance(Long id) {
	    Account acc = repo.findById(id).get();
	    acc.setBalance(200);
	}
	
}
