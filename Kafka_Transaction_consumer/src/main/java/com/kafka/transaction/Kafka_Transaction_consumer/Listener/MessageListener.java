package com.kafka.transaction.Kafka_Transaction_consumer.Listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service
public class MessageListener {

	 @Autowired
	 private orderHistoryRepository orderRepository;
	
	 /*
	@KafkaListener(topics = "order-topic", groupId = "order-group")
    public void listen(com.company.avro.order  msg) {
		System.out.println("Received: " + msg + " at " + System.currentTimeMillis());
    }*/
	
	//----------kafka transaction-----------------
	
	       @KafkaListener(
			    topics = "order-topic",
			    groupId = "order-group",
			    properties = {
			        "isolation.level=read_committed"
			    }
			)
			public void consume1(String message) {
			    System.out.println("Received order order-topic: " + message);
			}
	       
	       @KafkaListener(
				    topics = "topic-A",
				    properties = {
				        "isolation.level=read_committed"
				    }
				)
				public void consume2(String message) {
				    System.out.println("Received order by topic-A: " + message);
				}
}
