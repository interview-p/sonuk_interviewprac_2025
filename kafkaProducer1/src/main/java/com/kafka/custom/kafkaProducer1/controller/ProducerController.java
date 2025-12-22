package com.kafka.custom.kafkaProducer1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class ProducerController {

	private final KafkaTemplate<String, String> kafkaTemplate;
	

    public ProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/{msg}")
    public String sendMsg1(@PathVariable String msg) {
    	for (int i = 0; i < 10; i++) {
            kafkaTemplate.send(
                "topic-A",
                "key-" + i,        // 🔑 KEY
                msg + "-" + i
            );
        }
        return "sent";
    }
    @GetMapping("/msg1/{msg1}")
    public String sendMsg2(@PathVariable String msg1) {
  
        kafkaTemplate.send("topic-A", msg1);
        return "sent";
    }
    
    @PostMapping("/order")
    public ResponseEntity<String> createUser(@RequestBody Order request) {
        kafkaTemplate.send("order-topic", request.getProduct());
        System.out.println("Order sent: " + request);
        return ResponseEntity.status(HttpStatus.CREATED).body("sent");
    }
    
}
