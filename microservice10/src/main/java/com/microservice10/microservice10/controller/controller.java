package com.microservice10.microservice10.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/micro10")
public class controller {

	 private static final Logger log = LoggerFactory.getLogger(controller.class);
	 
	 @GetMapping("/order")
	  public String order(@RequestParam(defaultValue = "item1") String item) {
	    log.info("Processing order for {}", item);
	    return "Order processed for " + item;
	  }
}
