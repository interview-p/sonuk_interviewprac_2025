package com.multithreading.Multithreading.Concept.DeadLock;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/deadlock")
public class DeadlockController {

	private final OrderService orderService;
    private final InventoryService inventoryService;
    
    private final OrderService_reetrantLock orderService1;
    private final InventoryService_reetrantLock inventoryService1;

    public DeadlockController(OrderService orderService,
                              InventoryService inventoryService,
                              OrderService_reetrantLock orderService1,
                              InventoryService_reetrantLock inventoryService1) {
        this.orderService = orderService;
        this.inventoryService = inventoryService;
        this.inventoryService1 = inventoryService1;
        this.orderService1 = orderService1;
    }

    @GetMapping("/orderd")
    public String order() {
    	     String threadname = "order-thread";
        orderService.placeOrder(threadname);
        return "order placed";
    }

    @GetMapping("/inventoryd")
    public String inventory() {
    	String threadname = "order-thread";
        inventoryService.reserveStock(threadname);
        return "inventory reserved";
    }
    
    //---------------------------------------------------
    
    @GetMapping("/order1")
    public String order1() {
    	     String threadname = "order-thread";
        orderService1.placeOrder();
        return "order placed";
    }

    @GetMapping("/inventory1")
    public String inventory1() {
    	String threadname = "order-thread";
        inventoryService1.reserveStock();
        return "inventory reserved";
    }
}
