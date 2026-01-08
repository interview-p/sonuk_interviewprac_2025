package com.kafka.debeziumConsumer.kafkaDebeziumConsumer.Listener;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class DebeziumConsumer {

	@KafkaListener(topics = "appdb.public.users", groupId = "appdb-consumer")
	public void listen(ConsumerRecord<String, GenericRecord> record,Acknowledgment ack) {

       GenericRecord value = record.value();

       if (false) {
           throw new RuntimeException("Invalid message");
       }
       System.out.println("Received event: " + value);

       ack.acknowledge();
}
}
