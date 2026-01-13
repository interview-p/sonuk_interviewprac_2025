package com.kafka.transaction.Kafka_Transaction.db_kafka_transaction;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "outbox_event")
public class OutboxEvent {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String aggregateType;   // ORDER
	    private String aggregateId;     // orderId
	    private String eventType;       // ORDER_CREATED

	    @Column(columnDefinition = "TEXT")
	    private String payload;         // JSON

	    private boolean published;

	    private LocalDateTime createdAt;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getAggregateType() {
			return aggregateType;
		}

		public void setAggregateType(String aggregateType) {
			this.aggregateType = aggregateType;
		}

		public String getAggregateId() {
			return aggregateId;
		}

		public void setAggregateId(String aggregateId) {
			this.aggregateId = aggregateId;
		}

		public String getEventType() {
			return eventType;
		}

		public void setEventType(String eventType) {
			this.eventType = eventType;
		}

		public String getPayload() {
			return payload;
		}

		public void setPayload(String payload) {
			this.payload = payload;
		}

		public boolean isPublished() {
			return published;
		}

		public void setPublished(boolean published) {
			this.published = published;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}


	    
}
