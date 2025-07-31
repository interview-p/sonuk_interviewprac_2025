package com.skt.SpringAi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringAI {

	public static void main(String[] args) {
		SpringApplication.run(SpringAI.class, args);
	}

}
