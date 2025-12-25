package com.multithreading.Multithreading.Concept.LiveLock;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/livelock")
public class LivelockController {

	private final OrderServiceL orderService;
    private final InventoryServiceL inventoryService;
    
 

    public LivelockController(OrderServiceL orderService,
                              InventoryServiceL inventoryService) {
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
