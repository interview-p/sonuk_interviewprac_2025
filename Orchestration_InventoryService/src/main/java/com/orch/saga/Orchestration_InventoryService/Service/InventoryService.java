package com.orch.saga.Orchestration_InventoryService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.company.avro.order;
import com.orch.saga.SagaEvent;

@Service
public class InventoryService {

	@Autowired
    private KafkaTemplate<String, SagaEvent> kafkaTemplate;
    
	public void reserveInventory(SagaEvent event) {
	    boolean available = true;

	    if (available) {
	        kafkaTemplate.send("saga-events",
	            new SagaEvent(event.getSagaId(), event.getOrderId(),
	                "INVENTORY_RESERVED", ""));
	    } else {
	        kafkaTemplate.send("saga-events",
	            new SagaEvent(event.getSagaId(), event.getOrderId(),
	                "INVENTORY_FAILED", ""));
	    }
	}
	
}
