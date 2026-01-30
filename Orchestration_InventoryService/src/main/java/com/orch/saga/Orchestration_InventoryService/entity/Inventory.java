package com.orch.saga.Orchestration_InventoryService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {

	    @Id
	    private String productId;

	    private int availableQuantity;

	    private int reservedQuantity;

	    public Inventory() {
	    }

	    public Inventory(String productId, int availableQuantity, int reservedQuantity) {
	        this.productId = productId;
	        this.availableQuantity = availableQuantity;
	        this.reservedQuantity = reservedQuantity;
	    }

	    public String getProductId() {
	        return productId;
	    }

	    public int getAvailableQuantity() {
	        return availableQuantity;
	    }

	    public int getReservedQuantity() {
	        return reservedQuantity;
	    }

	    public void reserve(int qty) {
	        this.availableQuantity -= qty;
	        this.reservedQuantity += qty;
	    }

	    public void release(int qty) {
	        this.availableQuantity += qty;
	        this.reservedQuantity -= qty;
	    }
	    
}
