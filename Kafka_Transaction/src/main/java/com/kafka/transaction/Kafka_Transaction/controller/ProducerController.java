package com.kafka.transaction.Kafka_Transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.transaction.Kafka_Transaction.db_kafka_transaction.Order;
import com.kafka.transaction.Kafka_Transaction.db_kafka_transaction.OrderService;
import com.kafka.transaction.Kafka_Transaction.kafka_transaction.OrderProducer;

@RestController
@RequestMapping("/produce")
public class ProducerController {

	@Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    OrderProducer orderProducer;

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {

        kafkaTemplate.send("order-topic",order);

        return ResponseEntity.ok("Order sent successfully");
    }
    
    //----------------------check kafka transaction------------------
    
    @PostMapping("/transaction")
    public ResponseEntity<String> transaction1(@RequestBody Order order) {

    	orderService.placeOrder(order);

        return ResponseEntity.ok("Order sent successfully");
    }
    
    @GetMapping("/kafkatransaction/{msg}")
    public ResponseEntity<String> transaction2(@PathVariable String msg) {

    	    orderProducer.publishOrder(msg);

        return ResponseEntity.ok("Order sent successfully");
    }
}
