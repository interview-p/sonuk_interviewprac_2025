package com.orch.saga.OrchestrationPaymentservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import com.orch.saga.SagaEvent;

public class PaymentService {

	@Autowired
    private KafkaTemplate<String, SagaEvent> kafkaTemplate;
	
	@KafkaListener(topics = "payment-events")
	public void consume(SagaEvent event) {
	    processPayment(event);
	}
	
	public void processPayment(SagaEvent event) {

	    boolean approved = true; // simulate manual approval signal

	    if (approved) {
	        kafkaTemplate.send("saga-events",
	            new SagaEvent(event.getSagaId(), event.getOrderId(),
	                "PAYMENT_SUCCESS", ""));
	    } else {
	        kafkaTemplate.send("saga-events",
	            new SagaEvent(event.getSagaId(), event.getOrderId(),
	                "PAYMENT_PENDING", ""));
	    }
	}
}
