package com.graphql.graphqlTest.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.graphqlTest.Entity.Order;
import com.graphql.graphqlTest.Entity.Payment;
import com.graphql.graphqlTest.service.OrderService;
import com.graphql.graphqlTest.service.PaymentService;

@Controller
public class PaymentController {

	private final PaymentService paymentService;
    private final OrderService orderService;

    public PaymentController(PaymentService paymentService, OrderService orderService) {
        this.paymentService = paymentService;
        this.orderService = orderService;
    }

    // =========================
    // Queries
    // =========================

    @QueryMapping
    public Payment getPaymentById(@Argument Integer id) {
        return paymentService.getPaymentById(id).orElse(null);
    }

    @QueryMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // =========================
    // Mutations
    // =========================

    @MutationMapping
    public Payment createPayment(@Argument Integer orderId,
                                 @Argument Double amount,
                                 @Argument String status) {
        // Fetch the order first
        Order order = orderService.getOrderById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // Create payment and associate with order
        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setStatus(status);
        payment.setOrder(order);

        // Optional: set order.payment if you want bidirectional sync
        order.setPayment(payment);

        return paymentService.createPayment(payment);
    }
    
}
