package com.AvroProducer1.kafka_AvroConsumer1.Listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service
public class MessageListener {

	
	
	 
	@KafkaListener(topics = "order-topic", groupId = "order-group")
    public void listen(com.company.avro.order  msg) {
		System.out.println("Received: " + msg + " at " + System.currentTimeMillis());
    }
	

}
