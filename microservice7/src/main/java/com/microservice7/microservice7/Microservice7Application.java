package com.microservice7.microservice7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Microservice7Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice7Application.class, args);
	}

}
