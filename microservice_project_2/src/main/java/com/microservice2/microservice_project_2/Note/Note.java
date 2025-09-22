package com.microservice2.microservice_project_2.Note;

public class Note {

	/*

1. Class Setup

@Configuration → Marks this as a Spring configuration class.
All @Bean methods inside will be managed by Spring IoC container.

2. Events List

private final List<CircuitBreakerEvent> events = new ArrayList<>();
Stores circuit breaker events (state changes, failures, successes).
Helps track history of circuit breaker activity.

3. Expose Events as Bean

@Bean public List<CircuitBreakerEvent> circuitBreakerEvents()
Makes the events list available as a Spring Bean.
Other components can @Autowired it.

4. CircuitBreaker Registry

@Bean public CircuitBreakerRegistry circuitBreakerRegistry()
Creates a registry to manage multiple circuit breakers.
Provides a centralized way to create/retrieve circuit breakers.
Uses default config (ofDefaults()).

5. CircuitBreaker Custom Config

Built using CircuitBreakerConfig.custom() with settings:
failureRateThreshold(50) → Circuit opens if 50% of calls fail.
waitDurationInOpenState(5s) → Stays open for 5 seconds before retry.
slidingWindowSize(2) → Evaluates last 2 calls.
minimumNumberOfCalls(2) → Needs at least 2 calls to calculate failure rate.

6. Create CircuitBreaker Instance

registry.circuitBreaker("remoteService", config)
Registers a circuit breaker named remoteService with the above config.
Any component can retrieve it from registry by name.

7. Event Subscriptions

Logging:
circuitBreaker.getEventPublisher().onEvent(event -> 
    System.out.println("CircuitBreaker Event: " + event));

→ Logs all events to console.
Storing:
circuitBreaker.getEventPublisher().onEvent(events::add);
→ Adds events to events list for later inspection.

8. Bean Exposure

return circuitBreaker;
Exposes remoteServiceCircuitBreaker as a Spring Bean.
Other classes can @Autowired CircuitBreaker remoteServiceCircuitBreaker.


🔎 Meaning

CircuitBreakerRegistry →
A central registry (factory + storage) provided by Resilience4j.
It holds and manages all the CircuitBreaker instances in your application.

ofDefaults() →
A static factory method that creates a new CircuitBreakerRegistry using the default configuration.

📌 What Default Configuration Includes

When you call ofDefaults(), Resilience4j creates a registry with these built-in default settings (unless overridden later):
Failure rate threshold → 50%
Wait duration in OPEN state → 60 seconds

Sliding window size → 100 calls
Minimum number of calls → 100 before evaluating failure rate
Permitted calls in half-open state → 10
Automatic transition from OPEN → HALF_OPEN → disabled (manual or on first call)
(These are Resilience4j’s defaults — much higher than your custom config.)

📌 Why Use ofDefaults()

Quick start → You don’t have to configure everything if defaults are fine.
Centralized management → Later, you can register circuit breakers into this registry with custom configs.
Integration with Spring Boot Actuator → The registry makes it easy for actuator endpoints to list circuit breakers.

🔧 Example
CircuitBreakerRegistry registry = CircuitBreakerRegistry.ofDefaults();
// Using default config
CircuitBreaker cb1 = registry.circuitBreaker("service1");
// Using custom config
CircuitBreakerConfig customConfig = CircuitBreakerConfig.custom()
    .failureRateThreshold(30)
    .build();
CircuitBreaker cb2 = registry.circuitBreaker("service2", customConfig);


Here:

cb1 → uses default settings from ofDefaults().
cb2 → uses custom settings provided explicitly.

✅ So in your code,

@Bean
public CircuitBreakerRegistry circuitBreakerRegistry() {
    return CircuitBreakerRegistry.ofDefaults();
}



sort note- CircuitBreakerRegistry.ofDefaults() creates a central registry bean with
Resilience4j’s default circuit breaker settings (50% failure rate, 60s wait in open state, 
100-call sliding window, etc.). This registry acts as a factory and store for all circuit 
breakers, making it easy to manage them in one place, reuse them across services, and expose 
them via Spring Boot Actuator. Custom configs can still be applied per circuit breaker while
 keeping the registry as the central manager.
 
 
	 */
}
