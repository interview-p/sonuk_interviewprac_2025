package com.orch.saga.Orchestration_orderService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orch.saga.Orchestration_orderService.Entity.OrderEntity;
import com.orch.saga.Orchestration_orderService.Module.Order;
import com.orch.saga.Orchestration_orderService.producer.OrderEventProducer;
import com.orch.saga.Orchestration_orderService.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderEventProducer orderEventProducer;
	
	@Autowired
	private OrderRepository orderRepository;
	
	public String createOrder(Order order) {
	    OrderEntity order1 = new OrderEntity(order.getOrderId(),order.getProduct(), order.getAmount(),"CREATED");
	    orderRepository.save(order1);

	    orderEventProducer.sendOrderCreated(order.getOrderId());
	    return order.getOrderId();
	}
	
}
