package com.skt.educationApi.TransactionIsolationCheckAndLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactionisolation")
public class Controller1 {

	@Autowired
	private AccountService service;
	
	@Autowired
	private OpstimisticLocking opsLocking;
	
	@GetMapping("/nonrepeatedread")
    public String checkbalance() throws Exception {
    	    service.checkBalance((long)1);
        return "rollbacknothappen successful";
    }
	
	@GetMapping("/updatebalance")
    public String update() throws Exception {
    	    service.updateBalance((long)1);
        return "rollbacknothappen successful";
    }
	
	//--------------Phantom------------
	
	@GetMapping("/phantomread")
    public String phantomread() throws Exception {
    	    service.countNewOrders();
        return "phantom successful";
    }
	
	@GetMapping("/updateorder")
    public String updateorder() throws Exception {
    	    service.createOrder();
        return "updateorder successful";
    }
	
	//--------------opstismictic Locking-----------------
	
	@GetMapping("opslock/{id}/{amount}")
    public String addMoney(@PathVariable Long id, @PathVariable int amount) {
		opsLocking.addMoneyWithRetry(id, amount);
        return "OK";
    }
}
