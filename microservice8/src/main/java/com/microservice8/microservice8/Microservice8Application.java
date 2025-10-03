package com.microservice8.microservice8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Microservice8Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice8Application.class, args);
	}

}
