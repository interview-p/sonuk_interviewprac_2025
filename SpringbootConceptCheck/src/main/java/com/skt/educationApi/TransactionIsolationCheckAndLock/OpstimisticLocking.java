package com.skt.educationApi.TransactionIsolationCheckAndLock;

import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OpstimisticLocking {

	private final AccountRepository repo;

    public OpstimisticLocking(AccountRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public void addMoney(Long id, int amount) {
        Account acc = repo.findById(id).orElseThrow();
        acc.setBalance(acc.getBalance() + amount);
        repo.save(acc);
    }

    // retry wrapper
    public void addMoneyWithRetry(Long id, int amount) {
        int retries = 3;

        while (retries-- > 0) {
            try {
                addMoney(id, amount);
                return;
            } catch (ObjectOptimisticLockingFailureException  e) {
                System.out.println("Optimistic lock failed, retrying...");
            }
        }
        throw new RuntimeException("Too much contention");
    }
    
    /*
     * How to test:-
     * 1> add version coulmn with @version annotation - hibernate internally generate value from 1 than 2 than 3 and so on...
     * 2> create one concurrencyTestController -> where we create one task to call "addMoneyWithRetry" method and call to concurrent thread
     * 3> call the rest api which try to concurrrently update the data
     * 
     * what is opstimistic locking:-
     * Two users add money to the same account at the same time
       → without optimistic locking → lost update
       → with optimistic locking → one fails, retry works
       
       step by step execution:-
       first hibernate call Account acc = repo.findById(id).orElseThrow();
       method with id = 1 it found balance = 100 and version = 1
       than T1 update it with balance 150 and version = 2(auto generate 
       
       now when T2 come and fetch Account acc = repo.findById(id).orElseThrow();
       with id =1 found balance = 150 and version = 1
       now hibernate try to update with sql like
       UPDATE account SET balance = 150, version = 2 WHERE id = 1 AND version = 1;
        but but db not found version = 1 bcoz it became 2
        so in that case no row update and hibernate expecting row update = 1
        in that it throw error  "ObjectOptimisticLockingFailureException" 
        
        to solve this we retry 3 time at least becase again when T2 come
        and fetch with id = 1
        it found balance = 150 and version = 2
        and it run UPDATE account SET balance = 200, version = 2 WHERE id = 1 AND version = 2;
        which run successfully
     */
    
}
