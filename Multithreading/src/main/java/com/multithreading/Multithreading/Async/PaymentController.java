package com.multithreading.Multithreading.Async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	@Autowired
    private PaymentService_notwork paymentService;

    @GetMapping("/pay")
    public String pay() {
        paymentService.processPayment();
        return "done";
    }
    
    
    @Autowired
    private PaymentAsyncService_work asyncService;
    
    @GetMapping("/payw")
    public void processPayment() {
        System.out.println("Thread before async: " + Thread.currentThread().getName());

        asyncService.asyncTask(); // ✅ proxy call
    }
    //Controller → PaymentService → Proxy → Async Executor
}
