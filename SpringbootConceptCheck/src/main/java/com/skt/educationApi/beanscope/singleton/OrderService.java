package com.skt.educationApi.beanscope.singleton;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

	    private final LoggerService loggerService;

	    public OrderService(LoggerService loggerService) {
	        this.loggerService = loggerService;
	    }

	    public void placeOrder(String orderId) {
	        loggerService.log("Placing order with ID: " + orderId);
	        // business logic
	    }
}
