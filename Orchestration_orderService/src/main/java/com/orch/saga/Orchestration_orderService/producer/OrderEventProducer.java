package com.orch.saga.Orchestration_orderService.producer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.orch.saga.SagaEvent;

@Component
public class OrderEventProducer {

	@Autowired
    private KafkaTemplate<String, SagaEvent> kafkaTemplate;
	
	public void sendOrderCreated(String orderId) {
	    kafkaTemplate.send("saga-events",
	        new SagaEvent(UUID.randomUUID().toString(), orderId, "ORDER_CREATED", ""));
	}
	
}
