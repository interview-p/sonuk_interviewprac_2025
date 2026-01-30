package com.orch.saga.OrchestrationSagaEngine.Event;

public class SagaEvents {

	 private String sagaId;
	    private String orderId;
	    private String type; // ORDER_CREATED, INVENTORY_RESERVED, PAYMENT_FAILED
	    private String payload;
	    
	    
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
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getPayload() {
			return payload;
		}
		public void setPayload(String payload) {
			this.payload = payload;
		}
		public SagaEvents(String sagaId, String orderId, String type, String payload) {
			super();
			this.sagaId = sagaId;
			this.orderId = orderId;
			this.type = type;
			this.payload = payload;
		}
		
		
	    
	    
}
