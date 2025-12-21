package com.kafka.consumer.kafkaConsumerorder.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

	  private final KafkaTemplate<String, Payment> kafkaTemplate;

	    public OrderConsumer(KafkaTemplate<String, Payment> kafkaTemplate) {
	        this.kafkaTemplate = kafkaTemplate;
	    }

	    @KafkaListener(
	        topics = "order-topic",
	        groupId = "order-group",
	        concurrency = "3"
	    )
	    public void consume(Order order) {
	        boolean paymentSuccess = Math.random() > 0.5;

	        Payment payment = new Payment(order.getOrderId(), paymentSuccess);
	        kafkaTemplate.send("payment-topic", payment);
	    }
	    
}
