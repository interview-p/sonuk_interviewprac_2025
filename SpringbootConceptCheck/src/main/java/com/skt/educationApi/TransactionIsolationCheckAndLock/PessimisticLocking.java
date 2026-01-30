package com.skt.educationApi.TransactionIsolationCheckAndLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PessimisticLocking {

	@Autowired
	private AccountRepository repo;

    @Transactional
    public void addMoney(Long id, int amount) {

        Account acc = repo.findByIdForUpdate(id); // 🔒 LOCK HERE

        /*
        try {
            Thread.sleep(5000); // simulate long processing
        } catch (InterruptedException e) {}
        */
        acc.setBalance(acc.getBalance() + amount);
    }
    
    /*
     * as opstimistic lock happen passimistic lock work differntly here we do not use 
     * any try of retry . here we use lock
     * 
     * when T1 come and execute query it apply lock on that thread when other thread
     * try to access this query it wait for some time as we specify at query level
     * 
     * in insideMoney we use Thread.sleep() mean it wait T1 thread(which come first)
     * for 5 sec after lock apply when T2 thread come and run query hibernate 
     * ask T2 thread wait for 3 sec only but T1 goes sleep for 5 sec after executimng query
     * due to this after 3 sec(as per query) T2 not acquire Lock and hibernate
     * throw exception
     */
}
