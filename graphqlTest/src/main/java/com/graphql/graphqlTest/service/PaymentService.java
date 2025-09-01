package com.graphql.graphqlTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.graphql.graphqlTest.Entity.Payment;
import com.graphql.graphqlTest.Repository.PaymentRepository;

@Service
public class PaymentService {

	private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Optional<Payment> getPaymentById(Integer id) {
        return paymentRepository.findById(id);
    }

    public Optional<Payment> getPaymentByOrderId(Integer orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePayment(Integer id) {
        paymentRepository.deleteById(id);
    }

	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}
    
}
