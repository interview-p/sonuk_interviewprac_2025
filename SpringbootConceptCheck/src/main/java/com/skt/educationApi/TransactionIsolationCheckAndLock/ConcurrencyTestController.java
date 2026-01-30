package com.skt.educationApi.TransactionIsolationCheckAndLock;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ConcurrencyTestController {

	@Autowired
	private OpstimisticLocking service;
	
	@Autowired
	private PessimisticLocking perservice;

    @GetMapping("/opsconcurrent")
    public String testConcurrent1() throws Exception {

        CountDownLatch latch = new CountDownLatch(1);

        Runnable task = () -> {
            try {
                latch.await(); // wait for signal
                service.addMoneyWithRetry(1L, 50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        Thread.sleep(100); // ensure both threads are ready
        latch.countDown(); // 🔥 start both together

        return "Triggered";
    }
    
    //--------------passimistic locking----------------------
    
    @GetMapping("/passconcurrent")
    public String testConcurrent2() throws Exception {

        CountDownLatch latch = new CountDownLatch(1);

        Runnable task = () -> {
            try {
                latch.await(); // wait for signal
                perservice.addMoney(1L, 50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        Thread.sleep(100); // ensure both threads are ready
        latch.countDown(); // 🔥 start both together

        return "Triggered";
    }
}
