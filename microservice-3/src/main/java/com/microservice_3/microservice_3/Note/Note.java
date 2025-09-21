package com.microservice_3.microservice_3.Note;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

public class Note {

	/*
	circuit-Breaker -> A circuit breaker monitors for failures and temporarily halts the 
	 operation when certain conditions are met, allowing time for the system to recover
	 
	 -> it basically used to restrict to overload one microservices
	    mean micro-1 which connected by micro-2,micro-3 if for some reason micro-1 halt or not 
	    responding in that sitiation micro-2 and 3 hit 2-3 time as limit set thanafter 
	    circuite open and micro-2,3 and unable to hit micro-1 in mean time it get change to
	    recover.
	    
	    ----------there are multiple status of circuit-----
	    
	    
	    
	    ----------Observation during implementation--------
	    
	   1> @CircuitBreaker(name = "remoteService", fallbackMethod = "fallback")
	    -> when we write this annotation above any method(method in which another third party
	       service call)  it is eligiable for circuitbreaker
	       
	    -> name = "remoterServer" - it basically called instance in conext of resilliance4j
	       which observing third party url getting proper response or not
	      
	       resilience4j.circuitbreaker.instances.remoteService.slidingWindowSize=2
	       
	       above properties given in application.properties if you can see "instance.remoteService.slidingWindow"
	       given in which "remoterService" is used is same as given in name value in 
	       @circuitbreaker annotation 
	       if we annotate another method we can given name as remoteServer2 as we want
	       based on that instance configure another properties you can check in application.properties file
	       
	    -> fallbackMethod - for each circuitBreaker instance we write one fallback method
	       where we return message like "service you are calling is unavaiable"
	       
	        
	    2> circuitbreaker work on the basis of resialnce4j+actuator+spring AOP
	    
	    3> what i make mistake in development i hit the service circuitBreaker not work becuase my spring not able to create 
	       proxies
	       what i do i just add aop dependency in pom and add annotation at main method "@EnableAspectJAutoProxy(proxyTargetClass = true)"
	       sometime spring not able to create proxy it'seld . adding this annotation spring create proxy at runtime and my issue solved
	       
	       
	    
	    
	    
	    
------------------------how Resilance4j work internally with AOP and Actualtor----------------	    
	  
Spring AOP (Aspect-Oriented Programming) is how method-level annotations like @CircuitBreaker actually “work” under the hood.

🔹 How it works:

You define a method with:
@CircuitBreaker(name = "remoteService", fallbackMethod = "fallback")
public String callRemoteService() { ... }

Spring Boot sees this annotation during startup and creates a proxy of the bean.
If your class is concrete (not final) and method is public, Spring uses CGLIB proxy.
If it’s an interface, it can use JDK dynamic proxy.
The proxy wraps the real method. When your controller calls:
circuitBreakerService.callRemoteService()
it actually calls the proxy, not the real method.
The proxy intercepts the call:
Checks the circuit breaker state (CLOSED, OPEN, HALF_OPEN) for the given name.
If OPEN, immediately calls the fallback method.
If CLOSED or HALF_OPEN, calls the real method and records success/failure.
After the method finishes, the proxy publishes events to Resilience4j’s internal event system (CircuitBreakerEventPublisher).

 * importance of circuitBreakerRegistry ---------------------------

CircuitBreakerRegistry is the central store of all circuit breakers in your application. Think of it as a “factory + registry”:
Factory: Creates new CircuitBreaker instances programmatically.
Registry: Keeps track of all created circuit breakers so they can be shared, monitored, or queried.
Every CircuitBreaker has a unique name. You can retrieve it later by that name.

Central management
CircuitBreakerRegistry registry = CircuitBreakerRegistry.ofDefaults();
CircuitBreaker cb = registry.circuitBreaker("remoteService");

You can create/retrieve circuit breakers programmatically.
No duplicate instances with the same name are created.

Configuration management

You can supply default config when creating the registry, or custom config per instance programitically or provide in application.properties file

Event collection and monitoring

Each CircuitBreaker registers its events internally.
Actuator endpoints (/actuator/circuitbreakerevents) pull events from the registry.
Metrics aggregation
The registry allows you to iterate all circuit breakers to get metrics, events, or apply changes dynamically.
Even annotation-based circuit breakers are internally registered in a CircuitBreakerRegistry maintained by Spring + Resilience4j.


🔹 Important rules for proxying:

Spring-managed beans only: must be injected by Spring. new CircuitBreakerService() bypasses the proxy.
Method call must go through the proxy: calls to this.callRemoteService() inside the same class bypass proxy → annotations won’t work.
Public methods: CGLIB proxies require public methods. Private/final methods cannot be proxied.
Dependencies: spring-boot-starter-aop must be on the classpath.

2️⃣ How Actuator integrates with Resilience4j

Spring Boot Actuator exposes internal application metrics and events via HTTP endpoints. Resilience4j integrates with actuator in two ways:
🔹 1. Circuit breaker metrics:

Available at /actuator/metrics/resilience4j.circuitbreaker.calls
Example:

{
  "name": "remoteService",
  "type": "CircuitBreaker",
  "metrics": {
    "bufferedCalls": 5,
    "failedCalls": 2,
    "successCalls": 3
  }
}

These metrics are updated automatically by the proxy when you call a method with @CircuitBreaker.

Metrics include failure rate, buffered calls, slow calls, etc.

🔹 2. Circuit breaker events:

Available at /actuator/circuitbreakerevents
Every event like ERROR, STATE_TRANSITION, SUCCESS is recorded by Resilience4j’s EventPublisher.
The proxy triggers these events whenever the method call succeeds, fails, or the state changes.
Actuator endpoint reads these events from the internal registry and shows them.
	
	
	*/
}
