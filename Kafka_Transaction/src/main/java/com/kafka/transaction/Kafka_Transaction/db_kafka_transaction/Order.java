package com.kafka.transaction.Kafka_Transaction.db_kafka_transaction;

public class Order {

	private String orderId;
	 private String product;
	 private double amount;
	 
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
	 
	 
}
