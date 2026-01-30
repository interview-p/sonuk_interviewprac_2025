package com.skt.educationApi.TransactionIsolationCheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactionisolation")
public class Controller {

	@Autowired
	private AccountService service;
	
	@GetMapping("/rollbackhappencheckexception2")
    public String rollback_Happen_With_CheckException(@RequestParam String name) throws Exception {
    	    service.checkBalance((long)1);
        return "rollbacknothappen successful";
    }
}
