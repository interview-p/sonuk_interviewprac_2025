package com.graphql.graphqlTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.graphql.graphqlTest.Entity.Order;
import com.graphql.graphqlTest.Repository.OrderRepository;

@Service
public class OrderService {

	  private final OrderRepository orderRepository;

	    public OrderService(OrderRepository orderRepository) {
	        this.orderRepository = orderRepository;
	    }

	    public List<Order> getAllOrders() {
	        return orderRepository.findAll();
	    }

	    public Optional<Order> getOrderById(Integer id) {
	        return orderRepository.findById(id);
	    }

	    public Order createOrder(Order order) {
	        return orderRepository.save(order);
	    }

	    public void deleteOrder(Integer id) {
	        orderRepository.deleteById(id);
	    }
	    
}
