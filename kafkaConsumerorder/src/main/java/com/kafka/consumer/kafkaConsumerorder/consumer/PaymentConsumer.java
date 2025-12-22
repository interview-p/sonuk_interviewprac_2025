package com.kafka.consumer.kafkaConsumerorder.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {

	 @KafkaListener(
		        topics = "payment-topic",
		        groupId = "payment-group",
		        containerFactory = "paymentListenerFactory"
		    )
		    public void consume(
		            String payment,
		            Acknowledgment ack,
		            ConsumerRecord<String, String> record) {

		        System.out.println("Processing payment: " + payment);
                String[] x = payment.split("_");
		        if (!x[1].equals("success")) {
		            // ❌ This triggers retry
		            throw new RuntimeException("Payment failed");
		        }

		        // ✅ Success path
		        ack.acknowledge(); // offset committed ONLY here
		    }
}
