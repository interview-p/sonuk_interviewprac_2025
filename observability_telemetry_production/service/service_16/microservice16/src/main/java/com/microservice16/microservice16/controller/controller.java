package com.microservice16.microservice16.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/microservice15")
public class controller {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from service-a";
    }
}
