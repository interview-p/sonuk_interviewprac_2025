package com.multithreading.Multithreading.Concept.Bad_Starvation;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorConfig {

	@Bean("fastExecutor")
    public Executor fastExecutor() {
        return Executors.newFixedThreadPool(4);
    }

    @Bean("slowExecutor")
    public Executor slowExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}
