package com.grpc.grpcDemo;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrpcDemoApplication.class, args);
		System.out.println("-------------Default JVM TimeZone--------------: " + TimeZone.getDefault().getID());
	}

}
