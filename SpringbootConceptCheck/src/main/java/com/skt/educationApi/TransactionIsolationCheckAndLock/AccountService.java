package com.skt.educationApi.TransactionIsolationCheckAndLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Service
public class AccountService {

	@Autowired
	AccountRepository repo;
	
	@Autowired
	OrderRepo orrepo;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(isolation = Isolation.READ_COMMITTED)  // default = READ_COMMITTED
    public void checkBalance(Long id) throws Exception {
        Account a1 = repo.findById(id).get();
        System.out.println("First read: " + a1.getBalance());

        Thread.sleep(15000); // simulate long processing
        em.clear();

        Account a2 = repo.findById(id).get();
        System.out.println("Second read: " + a2.getBalance());
    }
	
	@Transactional
	public void updateBalance(Long id) {
	    Account acc = repo.findById(id).get();
	    acc.setBalance(200);
	}
	
	//--------------------phanton read---------------
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	//@Transactional
	public void countNewOrders() throws Exception {
	    long count1 = orrepo.countByStatusNative("NEW");
	    System.out.println("Count1: " + count1);

	    Thread.sleep(5000);

	    long count2 = orrepo.countByStatusNative("NEW");
	    System.out.println("Count2: " + count2);
	}
	
	@Transactional
	public void createOrder() {
	    Order o = new Order("NEW");
	    orrepo.save(o);
	}
	
	/*
	 * what is phantom count(new row apprear)
	 * first we insert one value in table mean count of new = 1
	 * if T1 read count as per above it read count = 1
	 * now sleep for 15 sec
	 * till than create one new order mean now count =2
	 * 
	 * if we do not apply isolation = serializable in @transaction 
	 * it read first counttime 1 than secount count 2
	 * 
	 * if apply
	 * it read first count =1 than secound count = 1
	 */
	
}
