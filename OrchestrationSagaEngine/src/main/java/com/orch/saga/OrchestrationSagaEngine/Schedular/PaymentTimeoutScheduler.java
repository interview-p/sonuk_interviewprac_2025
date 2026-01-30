package com.orch.saga.OrchestrationSagaEngine.Schedular;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import com.orch.saga.SagaEvent;
import com.orch.saga.OrchestrationSagaEngine.Entity.SagaState;
import com.orch.saga.OrchestrationSagaEngine.Repository.SagaStateRepository;

public class PaymentTimeoutScheduler {

	@Autowired
    private KafkaTemplate<String, SagaEvent> kafkaTemplate;
	
	@Autowired
	private SagaStateRepository sagaStateRepository;
	
	@Scheduled(fixedDelay = 10000)
	public void cancelIfPaymentNotDone() {

		 List<SagaState> pendingPayments =
	                sagaStateRepository.findPaymentPendingOlderThan("PAYMENT_PENDING","RUNNING",Instant.now().minusSeconds(10));

	        for (SagaState saga : pendingPayments) {

	            SagaEvent timeoutEvent = new SagaEvent(
	                    saga.getSagaId(),
	                    saga.getOrderId(),
	                    "PAYMENT_TIMEOUT",
	                    null
	            );

	            kafkaTemplate.send("saga-events", timeoutEvent);
	        }
	}
}
