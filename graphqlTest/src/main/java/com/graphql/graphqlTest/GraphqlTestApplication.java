package com.graphql.graphqlTest;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlTestApplication.class, args);
		System.out.println("-------------Default JVM TimeZone--------------: " + TimeZone.getDefault().getID());
	}

}
