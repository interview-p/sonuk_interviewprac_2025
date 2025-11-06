package com.obs.discoveryServer.OBSDiscoveryServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ObsDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObsDiscoveryServerApplication.class, args);
	}

}
