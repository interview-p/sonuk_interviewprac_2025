package com.service.discovery.logging.loggingServiceDiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LoggingServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggingServiceDiscoveryApplication.class, args);
	}

}
