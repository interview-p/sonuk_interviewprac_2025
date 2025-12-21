package com.kafka.consumer.kafkaConsumerorder.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

	        @KafkaListener(
		        topics = "payment-topic",
		        groupId = "email-group",
		        concurrency = "2"
		    )
		    public void consume(Payment payment) {
		        if (payment.isSuccess()) {
		            System.out.println("Email sent for order " + payment.getOrderId());
		        }
		    }
}
