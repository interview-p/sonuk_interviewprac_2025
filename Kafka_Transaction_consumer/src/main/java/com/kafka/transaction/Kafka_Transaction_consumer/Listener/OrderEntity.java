package com.kafka.transaction.Kafka_Transaction_consumer.Listener;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private String orderId;
	 private String product;
	 private double amount;
	 
	 public Long getId() {
		 return id;
	 }
	 
	 public void setId(Long id) {
		 this.id = id;
	 }
	 public String getOrderId() {
		 return orderId;
	 }
	 public void setOrderId(String orderId) {
		 this.orderId = orderId;
	 }
	 public String getProduct() {
		 return product;
	 }
	 public void setProduct(String product) {
		 this.product = product;
	 }
	 public double getAmount() {
		 return amount;
	 }
	 public void setAmount(double amount) {
		 this.amount = amount;
	 }
	 
	 public OrderEntity(String orderId, String product, double amount) {
			super();
			this.orderId = orderId;
			this.product = product;
			this.amount = amount;
		}
	 
	 
}
