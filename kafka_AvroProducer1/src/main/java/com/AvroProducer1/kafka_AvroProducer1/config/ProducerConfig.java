package com.AvroProducer1.kafka_AvroProducer1.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.avro.generic.GenericRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class ProducerConfig {

	/*
	    @Bean
	    public ProducerFactory<String, order> producerFactory() {
	        Map<String, Object> config = new HashMap<>();

	        config.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
	                "localhost:19092,localhost:19093,localhost:19094,localhost:19095,localhost:19096");
	       
	        config.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	                org.apache.kafka.common.serialization.StringSerializer.class);
	        config.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
	                org.apache.kafka.common.serialization.StringSerializer.class);
            
	        config.put(org.apache.kafka.clients.producer.ProducerConfig.ACKS_CONFIG, "all");
	        config.put(org.apache.kafka.clients.producer.ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
	        //config.put(org.apache.kafka.clients.producer.ProducerConfig.LINGER_MS_CONFIG, 5000);
	        config.put(org.apache.kafka.clients.producer.ProducerConfig.BATCH_SIZE_CONFIG, 32768);
	        config.put("schema.registry.url", "http://localhost:8081");

	        return new DefaultKafkaProducerFactory<>(config);
	    }
*/

}
