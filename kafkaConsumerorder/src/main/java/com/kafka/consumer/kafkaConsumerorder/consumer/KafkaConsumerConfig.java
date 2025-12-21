package com.kafka.consumer.kafkaConsumerorder.consumer;

import org.apache.kafka.common.message.ConsumerProtocolAssignment.TopicPartition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.ExponentialBackOffWithMaxRetries;
import org.springframework.scheduling.annotation.EnableAsync;


@Configuration
@EnableAsync
public class KafkaConsumerConfig {

	 @Bean
	    public ConcurrentKafkaListenerContainerFactory<String, Payment> paymentListenerFactory(
	            ConsumerFactory<String, Payment> consumerFactory,
	            KafkaTemplate<String, Object> kafkaTemplate) {

	        ConcurrentKafkaListenerContainerFactory<String, Payment> factory =
	                new ConcurrentKafkaListenerContainerFactory<>();

	        factory.setConsumerFactory(consumerFactory);

	        // ✅ Multithreading
	        factory.setConcurrency(3);

	        // ✅ Manual acknowledgment
	        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);

	        // ✅ Retry + Backoff + DLQ
	        DefaultErrorHandler errorHandler =
	                new DefaultErrorHandler(
	                        new DeadLetterPublishingRecoverer(
	                                kafkaTemplate,
	                                (record, ex) -> {
	                                    // Send to payment-dlq with same partition
	                                    return new org.apache.kafka.common.TopicPartition("payment-dlq", record.partition());
	                                }),
	                        new ExponentialBackOffWithMaxRetries(3) {{
	                            setInitialInterval(2000);
	                            setMultiplier(2);
	                            setMaxInterval(10000);
	                        }}
	                );

	        // ✅ Add headers to DLQ
	        errorHandler.addRetryableExceptions(RuntimeException.class);

	        factory.setCommonErrorHandler(errorHandler);

	        return factory;
	    }
	 
}
