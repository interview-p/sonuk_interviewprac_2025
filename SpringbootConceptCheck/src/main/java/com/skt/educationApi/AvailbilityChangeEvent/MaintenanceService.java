package com.skt.educationApi.AvailbilityChangeEvent;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceService {

	// this class is usecase of availbilitychangeevent 
	//Example Use Cases - it is just used by external tool
    /*
     Graceful shutdown: When you stop the app, it first publishes REFUSING_TRAFFIC. Kubernetes stops sending new requests, but Tomcat finishes in-flight ones. After a timeout, context closes.
     Cache warm-up: Your app may need 20s to load ML models into memory. Until then, you keep readiness = REFUSING, so no traffic is routed.
     Dependency health: If your DB or Kafka cluster is down, you can flip readiness = REFUSING so external load balancers stop sending traffic to this instance.
	
	*/
	private final ApplicationContext context;

    public MaintenanceService(ApplicationContext context) {
        this.context = context;
    }

    public void startMaintenance() {
        // Tell Spring Boot: don't accept traffic
        AvailabilityChangeEvent.publish(context, ReadinessState.REFUSING_TRAFFIC);
        System.out.println("App is in maintenance mode 🚧");
    }

    public void endMaintenance() {
        // Tell Spring Boot: ready again
        AvailabilityChangeEvent.publish(context, ReadinessState.ACCEPTING_TRAFFIC);
        System.out.println("App is back online ✅");
    }
}
