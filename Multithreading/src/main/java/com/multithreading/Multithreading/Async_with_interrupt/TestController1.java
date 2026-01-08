package com.multithreading.Multithreading.Async_with_interrupt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController1 {

	 private final PaymentService1 paymentService;

	    public TestController1(PaymentService1 paymentService) {
	        this.paymentService = paymentService;
	    }

	    @GetMapping("/pay1")
	    public String pay() {
	        paymentService.processPayment("ORDER-1");
	        return "Payment started";
	    }
}
