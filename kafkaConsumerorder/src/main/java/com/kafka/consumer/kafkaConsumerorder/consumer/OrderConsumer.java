package com.kafka.consumer.kafkaConsumerorder.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

	  private final KafkaTemplate<String, String> kafkaTemplate;

	    public OrderConsumer(KafkaTemplate<String, String> kafkaTemplate) {
	        this.kafkaTemplate = kafkaTemplate;
	    }

	    @KafkaListener(
	        topics = "order-topic",
	        groupId = "order-group",
	        concurrency = "3"
	    )
	    public void consume(String order) {
	        boolean paymentSuccess = Math.random() > 0.5;
            String payment = order+"_"+"successs";
	        //Payment payment = new Payment(order, paymentSuccess);
	        kafkaTemplate.send("payment-topic", payment);
	    }
	    
}
