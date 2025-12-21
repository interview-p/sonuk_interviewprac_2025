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
		            Payment payment,
		            Acknowledgment ack,
		            ConsumerRecord<String, Payment> record) {

		        System.out.println("Processing payment: " + payment);

		        if (!payment.isSuccess()) {
		            // ❌ This triggers retry
		            throw new RuntimeException("Payment failed");
		        }

		        // ✅ Success path
		        ack.acknowledge(); // offset committed ONLY here
		    }
}
