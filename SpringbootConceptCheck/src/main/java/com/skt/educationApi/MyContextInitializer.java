package com.skt.educationApi;

import java.util.Map;
import java.util.Properties;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

public class MyContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	
@Override
public void initialize(ConfigurableApplicationContext context) {
   
	System.out.println(">>> Customizing context: " + context.getClass().getName());

   
    ConfigurableEnvironment env = context.getEnvironment();
    // set enviroment
    //env.setActiveProfiles("default");
    // Example: add custom property source
    Properties props = new Properties();
    props.setProperty("app.custom.value", "456");
    env.getPropertySources().addFirst(new PropertiesPropertySource("myProps", props));
    
    System.out.println("after immediant property check = "+env.getProperty("app.custom.value"));
    
}


}
