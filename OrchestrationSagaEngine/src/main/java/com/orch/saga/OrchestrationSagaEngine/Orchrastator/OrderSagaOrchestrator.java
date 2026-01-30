package com.orch.saga.OrchestrationSagaEngine.Orchrastator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.orch.saga.SagaEvent;
import com.orch.saga.OrchestrationSagaEngine.Entity.SagaState;
import com.orch.saga.OrchestrationSagaEngine.Event.SagaEvents;
//import com.orch.saga.OrchestrationSagaEngine.Event.SagaEvent;
import com.orch.saga.OrchestrationSagaEngine.Repository.SagaStateRepository;

@Component
public class OrderSagaOrchestrator {

	@Autowired
    private KafkaTemplate<String, SagaEvent> kafkaTemplate;
	
	@Autowired
	private SagaStateRepository sagaStateRepository;
	
	public void handle(SagaEvents event) {

	    SagaState saga = sagaStateRepository
	        .findById(event.getSagaId())
	        .orElse(new SagaState(event.getSagaId(), event.getOrderId()));

	    SagaEvent av = new SagaEvent();
	    av.setOrderId(event.getOrderId());av.setSagaId(event.getSagaId());av.setType(event.getType());av.setPayload("");
	    switch (event.getType()) {

	        case "ORDER_CREATED":
	            saga.setCurrentStep("ORDER_CREATED");
	            kafkaTemplate.send("inventory-events", av);
	            break;

	        case "INVENTORY_RESERVED":
	            saga.setCurrentStep("INVENTORY_DONE");
	            kafkaTemplate.send("payment-events", av);
	            break;

	        case "PAYMENT_SUCCESS":
	            saga.setStatus("COMPLETED");
	            kafkaTemplate.send("order-events",
	                new SagaEvent(event.getSagaId(), event.getOrderId(),
	                    "ORDER_COMPLETED", ""));
	            break;

	        case "PAYMENT_TIMEOUT":
	        case "PAYMENT_FAILED":
	            compensateInventory(event);
	            cancelOrder(event);
	            saga.setStatus("FAILED");
	            break;
	    }

	    sagaStateRepository.save(saga);
	}
	
	
	private void compensateInventory(SagaEvents event) {
	    kafkaTemplate.send("inventory-events",
	        new SagaEvent(event.getSagaId(), event.getOrderId(),
	            "RELEASE_INVENTORY", ""));
	}
	
	private void cancelOrder(SagaEvents event) {

	    SagaEvent cancelOrderEvent = new SagaEvent(
	            event.getSagaId(),
	            event.getOrderId(),
	            "ORDER_CANCELED",
	            null
	    );

	    kafkaTemplate.send("saga-events", cancelOrderEvent);
	}
}
