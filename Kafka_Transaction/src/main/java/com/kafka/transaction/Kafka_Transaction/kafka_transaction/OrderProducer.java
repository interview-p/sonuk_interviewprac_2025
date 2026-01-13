package com.kafka.transaction.Kafka_Transaction.kafka_transaction;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class OrderProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    
    public void publishOrder(String orderId) {

    	kafkaTemplate.executeInTransaction(kt -> {
    	    kt.send("order-topic", orderId);
    	    kt.send("topic-A", orderId);
    	    
    	    if (true) {
    	        throw new RuntimeException("Force rollback");
    	    }
    	    return false;
    	});
    	
    	/*
    	 * 	to maintain kafka transaction we use executeInTransaction where produce message in 
     *  multiple topic if any exception(check and unchecked both) throw transaction
     *  aborted
     *  as in db in kafka transaction do not propogate and rollback
     *  
     *  Action required:-
     *  1> mention transaction-id-prefix: order-tx- in properties file. spring automatically create kafkaTransaction 
     *  2> if we not mention above properties we have to create bean with named kafkaTransaction
    	 */
    }
    
}
