package com.graphql.graphqlTest.DTO;

public class OrderSummaryDTO {

	    private Long orderId;
	    private String productName;
	    private Double amount;
	    private String paymentStatus;
	    private String transactionId;
	    
	    
		public OrderSummaryDTO(Long orderId, String productName, Double amount, String paymentStatus) {
			super();
			this.orderId = orderId;
			this.productName = productName;
			this.amount = amount;
			this.paymentStatus = paymentStatus;
		}
		
		public Long getOrderId() {
			return orderId;
		}
		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
		public String getPaymentStatus() {
			return paymentStatus;
		}
		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}
		public String getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}
	    
	    
}
