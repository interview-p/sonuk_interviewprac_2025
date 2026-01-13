package com.kafka.transaction.Kafka_Transaction.db_kafka_transaction;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.jackson.databind.ObjectMapper;

@Service
public class OrderService {

	 private final OrderRepository orderRepository;
	    private final OutboxRepository outboxRepository;
	    private final ObjectMapper objectMapper;

	    
	    public OrderService(OrderRepository orderRepository, OutboxRepository outboxRepository,
				ObjectMapper objectMapper) {
			this.orderRepository = orderRepository;
			this.outboxRepository = outboxRepository;
			this.objectMapper = objectMapper;
		}
	    

		@Transactional
	    public void placeOrder(Order order) {

	        // 1. Save order
	        OrderEntity saved = orderRepository.save(new OrderEntity(order.getOrderId(),order.getProduct(),order.getAmount()));

	        // 2. Create outbox event
	        OutboxEvent event = new OutboxEvent();
	        event.setAggregateId(saved.getId().toString());
	        event.setAggregateType("ORDER");
	        event.setEventType("ORDER_CREATED");
	        event.setPayload(toJson(saved));
	        event.setPublished(false);
	        event.setCreatedAt(LocalDateTime.now());
	        
	        outboxRepository.save(event);

	        // ❌ NO Kafka call here
	        // DB commit happens safely
	    }

	    private String toJson(Object obj) {
	        try {
	            return objectMapper.writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
}
