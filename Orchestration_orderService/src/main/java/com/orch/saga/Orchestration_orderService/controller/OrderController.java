package com.orch.saga.Orchestration_orderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orch.saga.Orchestration_orderService.Module.Order;
import com.orch.saga.Orchestration_orderService.service.OrderService;


@RestController
@RequestMapping("/orchOrder")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	public String placeOrder(@RequestBody Order order) {
	    return orderService.createOrder(order);
	}
}
