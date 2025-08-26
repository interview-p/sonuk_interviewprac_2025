package com.skt.educationApi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.skt.educationApi.SpringApplicationEventCheckClassess.contextinitCheck;

@SpringBootApplication
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
}
