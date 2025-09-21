package com.microservice2.microservice_project_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MicroserviceProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProject2Application.class, args);
	}

}
