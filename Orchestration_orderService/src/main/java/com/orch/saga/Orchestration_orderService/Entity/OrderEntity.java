package com.orch.saga.Orchestration_orderService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderId;

    private String productId;

    private int quantity;

    private String status;
    // CREATED, COMPLETED, CANCELED

    public OrderEntity() {
    }

    public OrderEntity(String orderId, String productId, int quantity, String status) {
      this.orderId = orderId;    
    	this.productId = productId;
        this.quantity = quantity;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public void markCompleted() {
        this.status = "COMPLETED";
    }

    public void markCanceled() {
        this.status = "CANCELED";
    }
}
