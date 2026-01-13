package com.kafka.transaction.Kafka_Transaction.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TransactionConfig {
/*
	 @Bean
	    public PlatformTransactionManager chainedTransactionManager(
	            @Qualifier("transactionManager") PlatformTransactionManager jpaTxManager,
	            @Qualifier("kafkaTransactionManager") PlatformTransactionManager kafkaTxManager) {

	        return new ChainedTransactionManager(jpaTxManager, kafkaTxManager);
	    }
	    
	    */
}
