package com.orch.saga.OrchestrationSagaEngine.Listener;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.orch.saga.SagaEvent;
import com.orch.saga.OrchestrationSagaEngine.Event.SagaEvents;
import com.orch.saga.OrchestrationSagaEngine.Orchrastator.OrderSagaOrchestrator;

public class SagaEventListener {

	@Autowired
	private OrderSagaOrchestrator orchestrator;
	
	@KafkaListener(topics = "saga-events")
	public void listen(SagaEvent event) {
		SagaEvents ev = new SagaEvents(event.getSagaId().toString(),event.getOrderId().toString(),event.getType().toString(),"");
	    orchestrator.handle(ev);
	}
	
}
