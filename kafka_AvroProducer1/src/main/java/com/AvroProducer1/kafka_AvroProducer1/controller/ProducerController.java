package com.AvroProducer1.kafka_AvroProducer1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.avro.order;


@RestController
@RequestMapping("/produce")
public class ProducerController {

	@Autowired
    private KafkaTemplate<String, order> kafkaTemplate;
    
   

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody order order) {

        kafkaTemplate.send("order-topic",order);

        return ResponseEntity.ok("Order sent successfully");
    }
    
   
}
