package com.orch.saga.Orchestration_InventoryService.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.orch.saga.SagaEvent;
import com.orch.saga.Orchestration_InventoryService.Service.InventoryService;

@Component
public class InventoryEventConsumer {

	@Autowired
	InventoryService inventoryService;
	
	@KafkaListener(topics = "inventory-events")
	public void consume(SagaEvent event) {
	    inventoryService.reserveInventory(event);
	}
}
