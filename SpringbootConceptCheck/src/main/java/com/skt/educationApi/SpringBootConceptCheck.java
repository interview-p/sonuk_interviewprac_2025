package com.skt.educationApi;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.skt.educationApi.SpringApplicationEventCheckClassess.contextinitCheck;
import com.skt.educationApi.beanscope.prototype.AuthService;

@SpringBootApplication
@EnableScheduling
public class SpringBootConceptCheck {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringBootConceptCheck.class);
		app.addInitializers(new MyContextInitializer());
		//app.setWebApplicationType(WebApplicationType.NONE); // disables web server
		app.run(args);
	}

	
	@Bean
    CommandLineRunner runner(contextinitCheck bean) {
        return args -> bean.printValue();
    }
	
	@Autowired
	public AuthService authservice;
	
	// to check prototype bean scope
	//@Scheduled(fixedRate = 60000) // runs every 60s
    public void cleanupExpiredTokens() {
        authservice.cleanupExpiredTokens();
    }
}
