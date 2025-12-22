package com.kafka.consumer.kafkaConsumerorder.consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private String orderId;
    private boolean success;
    
	public Payment(String orderId2, boolean paymentSuccess) {
		this.orderId=orderId2;
		this.success = paymentSuccess;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
    
    
}
