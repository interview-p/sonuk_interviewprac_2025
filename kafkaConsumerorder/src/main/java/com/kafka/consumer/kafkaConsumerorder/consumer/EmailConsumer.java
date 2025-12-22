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
		    public void consume(String payment) {
	        	    String[] x = payment.split("_");
		        if (x[1].equals("success")) {
		            System.out.println("Email sent for order " + x[0]);
		        }
		    }
}
