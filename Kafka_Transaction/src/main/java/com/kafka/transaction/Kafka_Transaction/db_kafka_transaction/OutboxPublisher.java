package com.kafka.transaction.Kafka_Transaction.db_kafka_transaction;

import java.util.List;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.company.avro.order;

import lombok.RequiredArgsConstructor;

@Component
public class OutboxPublisher {

	    private final OutboxRepository outboxRepository;
	    private final KafkaTemplate<String, String> kafkaTemplate;

	    
	    public OutboxPublisher(OutboxRepository outboxRepository, KafkaTemplate<String, String> kafkaTemplate) {
			super();
			this.outboxRepository = outboxRepository;
			this.kafkaTemplate = kafkaTemplate;
		}


		//@Scheduled(fixedDelay = 5000)
	    public void publishEvents() {

	        List<OutboxEvent> events =
	                outboxRepository.findTop10ByPublishedFalseOrderByCreatedAt();

	        for (OutboxEvent event : events) {
	            try {
	            	order r = new order();
	            	r.setOrderId(event.getAggregateId());
	            	r.setProductName(event.getEventType());
	                kafkaTemplate.send(
	                        "order-topic",
	                        r.toString()
	                ); // wait for ack

	                event.setPublished(true);
	                outboxRepository.save(event);

	            } catch (Exception ex) {
	                // ❌ Do NOT mark published
	                // Retry later
	            }
	        }
	    }
	    
}
