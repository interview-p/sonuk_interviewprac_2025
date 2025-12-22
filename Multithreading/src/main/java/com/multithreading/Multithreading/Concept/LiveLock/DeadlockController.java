package com.multithreading.Multithreading.Concept.LiveLock;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeadlockController {

	private final OrderService orderService;
    private final InventoryService inventoryService;
    
 

    public DeadlockController(OrderService orderService,
                              InventoryService inventoryService) {
        this.orderService = orderService;
        this.inventoryService = inventoryService;
    }

    @GetMapping("/order")
    public String order() {
    	     String threadname = "order-thread";
        orderService.placeOrder();
        return "order placed";
    }

    @GetMapping("/inventory")
    public String inventory() throws InterruptedException {
    	String threadname = "order-thread";
        inventoryService.reserveStock();
        return "inventory reserved";
    }
    
  
}
