package com.kafka.transaction.Kafka_Transaction.db_kafka_transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OutboxRepository extends JpaRepository<OutboxEvent, Long>{

	 List<OutboxEvent> findTop10ByPublishedFalseOrderByCreatedAt();
}
