package com.kafka.debeziumConsumer.kafkaDebeziumConsumer.configuration;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.common.TopicPartition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaConsumerConfig {

	/*
	 @Bean
	    public ConcurrentKafkaListenerContainerFactory<String, GenericRecord>
	    kafkaListenerContainerFactory(
	            ConsumerFactory<String, GenericRecord> consumerFactory,
	            KafkaTemplate<String, GenericRecord> kafkaTemplate
	    ) {

	        ConcurrentKafkaListenerContainerFactory<String, GenericRecord> factory =
	                new ConcurrentKafkaListenerContainerFactory<>();

	        factory.setConsumerFactory(consumerFactory);

	        DeadLetterPublishingRecoverer recoverer =
	                new DeadLetterPublishingRecoverer(
	                        kafkaTemplate,
	                        (record, ex) ->
	                                new TopicPartition("appdb-users-dlq", record.partition())
	                );

	        DefaultErrorHandler errorHandler =
	                new DefaultErrorHandler(
	                        recoverer,
	                        new FixedBackOff(3000L, 3) // retry 3 times
	                );

	        factory.setCommonErrorHandler(errorHandler);

	        return factory;
	    }
	    
	    */
	 
}
