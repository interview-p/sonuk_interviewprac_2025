package com.AvroProducer1.kafka_AvroConsumer1.Listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class MessageListener {

	
	@KafkaListener(topics = "order-topic", groupId = "order-group")
    public void listen(com.company.avro.order  msg) {
		System.out.println("Received: " + msg + " at " + System.currentTimeMillis());
    }
}
