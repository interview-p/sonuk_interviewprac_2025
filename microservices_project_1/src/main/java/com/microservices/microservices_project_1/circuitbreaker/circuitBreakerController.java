package com.microservices.microservices_project_1.circuitbreaker;

import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/circuit")
public class circuitBreakerController {

	private final Random random = new Random();

    @GetMapping("/api/data")
    public String getData() {
        // Simulate random failure random.nextBoolean()
        if (true) {
            throw new RuntimeException("Remote service failure!");
        }
        return "Remote service response success!";
    }
}
