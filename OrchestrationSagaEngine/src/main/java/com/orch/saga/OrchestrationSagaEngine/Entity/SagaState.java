package com.orch.saga.OrchestrationSagaEngine.Entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;

@Entity
public class SagaState {

	    @Id
	    private String sagaId;

	    private String orderId;

	    private String currentStep; 
	    // INVENTORY_DONE, PAYMENT_PENDING, COMPLETED

	    private String status; 
	    // RUNNING, FAILED, COMPLETE

		public String getSagaId() {
			return sagaId;
		}

		public void setSagaId(String sagaId) {
			this.sagaId = sagaId;
		}

		public String getOrderId() {
			return orderId;
		}

		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}

		public String getCurrentStep() {
			return currentStep;
		}

		public void setCurrentStep(String currentStep) {
			this.currentStep = currentStep;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public SagaState(String sagaId, String orderId) {
			super();
			this.sagaId = sagaId;
			this.orderId = orderId;
		}

		public SagaState(String sagaId, String orderId, String currentStep) {
			super();
			this.sagaId = sagaId;
			this.orderId = orderId;
			this.currentStep = currentStep;
		}

		public SagaState(String sagaId, String orderId, String currentStep, String status) {
			super();
			this.sagaId = sagaId;
			this.orderId = orderId;
			this.currentStep = currentStep;
			this.status = status;
		}
	    
	    
	    
}
