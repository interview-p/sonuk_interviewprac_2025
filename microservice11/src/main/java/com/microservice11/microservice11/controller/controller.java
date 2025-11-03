package com.microservice11.microservice11.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class controller {

	private static final Logger log = LoggerFactory.getLogger(controller.class);
	
	  @GetMapping("/pay")
	  public String pay(@RequestParam(defaultValue = "admin") String user) {
	    if (user.equals("admin")) {
	      log.error("SECURITY ALERT: unauthorized access attempt by {}", user);
	      return "Payment failed: unauthorized access";
	    } else {
	      log.info("Payment processed for {}", user);
	      return "Payment successful for " + user;
	    }
	  }
}
