package com.graphql.graphqlTest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.graphqlTest.Entity.Order;
import com.graphql.graphqlTest.Entity.User;
import com.graphql.graphqlTest.service.OrderService;
import com.graphql.graphqlTest.service.UserService;

@Controller
public class graphOrderController {

	    private final OrderService orderService;
	    private final UserService userService;

	    public graphOrderController(OrderService orderService, UserService userService) {
	        this.orderService = orderService;
	        this.userService = userService;
	    }
	    
	    @QueryMapping
	    List<Order> getAllOrder(){
	    	    return orderService.getAllOrders();
	    }
	    
	    @QueryMapping
	    Optional<Order> getAllOrderbyId(@Argument  Integer id){
	    	   return orderService.getOrderById(id);
	    }
	    
	    @MutationMapping
	    public Order createOrder(
	            @Argument Integer userId,
	            @Argument String productName,
	            @Argument Double amount
	    ) {
	        // Find the user
	        User user = userService.getUserById(userId)
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        // Create the order
	        Order order = new Order();
	        order.setProductName(productName);
	        order.setAmount(amount);
	        order.setUser(user);

	        return orderService.createOrder(order);
	    }
	    
	    @MutationMapping
	    public Boolean deleteOrder(@Argument Integer id) {
	        orderService.deleteOrder(id);
	        return true;
	    }
	    
	    
	    
}
