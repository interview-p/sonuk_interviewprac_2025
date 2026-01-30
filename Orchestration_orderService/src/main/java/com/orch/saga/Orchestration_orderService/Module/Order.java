package com.orch.saga.Orchestration_orderService.Module;

public class Order {

	private String orderId;
	 private String product;
	 private int amount;
	 
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
	 public int getAmount() {
		 return amount;
	 }
	 public void setAmount(int amount) {
		 this.amount = amount;
	 }
}
