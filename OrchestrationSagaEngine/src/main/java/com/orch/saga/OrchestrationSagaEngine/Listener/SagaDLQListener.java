package com.orch.saga.OrchestrationSagaEngine.Listener;


import org.springframework.kafka.annotation.KafkaListener;

import com.orch.saga.OrchestrationSagaEngine.Event.SagaEvents;

public class SagaDLQListener {

	@KafkaListener(topics = "saga-events.DLT")
	public void dlq(SagaEvents event) {
	    //log.error("DLQ EVENT {}", event);
	}
}
