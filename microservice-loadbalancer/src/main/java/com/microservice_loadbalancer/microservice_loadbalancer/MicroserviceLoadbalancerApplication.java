package com.microservice_loadbalancer.microservice_loadbalancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceLoadbalancerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceLoadbalancerApplication.class, args);
	}

}
