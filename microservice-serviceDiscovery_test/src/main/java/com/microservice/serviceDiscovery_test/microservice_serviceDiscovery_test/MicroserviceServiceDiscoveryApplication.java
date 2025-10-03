package com.microservice.serviceDiscovery_test.microservice_serviceDiscovery_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceServiceDiscoveryApplication.class, args);
	}

}
