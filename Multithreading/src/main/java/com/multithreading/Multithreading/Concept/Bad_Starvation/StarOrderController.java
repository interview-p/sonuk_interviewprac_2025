package com.multithreading.Multithreading.Concept.Bad_Starvation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/starorders")
public class StarOrderController {

	 private final StarOrderService orderService;

	    public StarOrderController(StarOrderService orderService) {
	        this.orderService = orderService;
	    }

	    @PostMapping("/fast")
	    public String placeOrder() {
	        orderService.placeOrder();
	        return "FAST request accepted";
	    }

	    @PostMapping("/slow")
	    public String generateReport() {
	        orderService.generateReport();
	        return "SLOW request accepted";
	    }
}
