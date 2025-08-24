package com.skt.educationApi;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class PreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {
    
	 @Override
	 public void onApplicationEvent(ApplicationPreparedEvent event) {
	        ConfigurableApplicationContext ctx = event.getApplicationContext();

	        ctx.getBeanFactory().registerSingleton("myExtraBean", new MyCustomService());
	        System.out.println(">>> Registered MyCustomService dynamically!");
	    }
	 
}
