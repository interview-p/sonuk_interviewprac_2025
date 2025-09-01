package com.graphql.graphqlTest.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.graphqlTest.DTO.OrderSummaryDTO;
import com.graphql.graphqlTest.service.OrderSummaryService;

@Controller
public class OrderSummaryGraphQLController {

	 private final OrderSummaryService orderSummaryService;

	    public OrderSummaryGraphQLController(OrderSummaryService orderSummaryService) {
	        this.orderSummaryService = orderSummaryService;
	    }

	    @QueryMapping
	    public OrderSummaryDTO getOrderSummary(@Argument Integer orderId) {
	        return orderSummaryService.getOrderSummary(orderId);
	    }
	    
}
