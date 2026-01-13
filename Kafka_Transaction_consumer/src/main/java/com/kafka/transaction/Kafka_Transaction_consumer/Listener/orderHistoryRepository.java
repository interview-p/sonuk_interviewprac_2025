package com.kafka.transaction.Kafka_Transaction_consumer.Listener;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderHistoryRepository extends JpaRepository<OrderEntity, Long>{

}
