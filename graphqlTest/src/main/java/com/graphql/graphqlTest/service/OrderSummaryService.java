package com.graphql.graphqlTest.service;

import org.springframework.stereotype.Service;

import com.graphql.graphqlTest.DTO.OrderSummaryDTO;
import com.graphql.graphqlTest.Entity.Order;
import com.graphql.graphqlTest.Entity.Payment;

@Service
public class OrderSummaryService {

	private final OrderService orderService;
    private final PaymentService paymentService;

    public OrderSummaryService(OrderService orderService, PaymentService paymentService) {
        this.orderService = orderService;
        this.paymentService = paymentService;
    }

    public OrderSummaryDTO getOrderSummary(Integer orderId) {
        Order order = orderService.getOrderById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        Payment payment = paymentService.getPaymentByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        return new OrderSummaryDTO(
                order.getId(),
                order.getProductName(),
                order.getAmount(),
                payment.getStatus()
                //payment.getTransactionid()
        );
    }
    
}
