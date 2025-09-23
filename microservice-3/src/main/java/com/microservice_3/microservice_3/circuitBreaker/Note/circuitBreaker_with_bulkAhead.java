package com.microservice_3.microservice_3.circuitBreaker.Note;

public class circuitBreaker_with_bulkAhead {

	/*
	
CircuitBreaker + Bulkhead Combination
1. Definition

CircuitBreaker: Monitors failures of a service and opens the circuit if failures exceed a threshold, preventing further calls.
Bulkhead: Limits the number of concurrent calls to a service, protecting it from overload.
Combined Purpose:
Bulkhead protects the system from too many simultaneous requests.
CircuitBreaker monitors failures, including Bulkhead rejections, to stop calls to a failing service.

2. Working Principle
Allowed concurrent calls
Bulkhead allows calls up to its maxConcurrentCalls limit.
These calls execute normally and count as successes in the CircuitBreaker.
Exceeded Bulkhead limit
Extra concurrent calls are rejected immediately.
Rejected calls trigger Bulkhead fallback, which can throw an exception.
CircuitBreaker counts these exceptions as failures.
if bulkahead fallback method not throw any exception it is not considered as failure
for circuitBreaker . Bulkahead just block the cuncurrent call further it will not
make circuitBreaker open 

CircuitBreaker opens(when bulkahead circuitBreaker throw exception)
If failures (including Bulkhead rejections) exceed the defined threshold, the circuit opens.

Subsequent calls bypass the service entirely and go to CircuitBreaker fallback.
CircuitBreaker resets
After waitDurationInOpenState, CircuitBreaker attempts a half-open state to check if the service is healthy again.

3. Example Scenario

Settings:
Bulkhead maxConcurrentCalls = 2
CircuitBreaker slidingWindowSize = 4, failureRateThreshold = 50%

Requests:

5 simultaneous requests:
2 allowed → execute normally → success.
3 rejected → Bulkhead fallback triggered → exceptions counted as failures by CircuitBreaker.

Outcome:
CircuitBreaker sees 3 failures out of 5 calls → failure rate > 50% → circuit opens.
Future requests go directly to CircuitBreaker fallback.
4. Key Takeaways
Bulkhead ensures concurrency control, prevents overload.
CircuitBreaker counts Bulkhead rejections (if fallback throws) toward failure rate.

Fallbacks:

Bulkhead fallback → optional, can throw exception to trigger CircuitBreaker.
CircuitBreaker fallback → user-facing response for failed calls.
This combination ensures both resilience under high concurrency and protection against failing services.

5. Testing

Open multiple browser tabs or use Postman to hit the API simultaneously.
Observe logs:
Allowed requests → normal processing.
Rejected requests → Bulkhead fallback → CircuitBreaker fallback.
Actuator endpoints can show circuit breaker events (/actuator/circuitbreakerevents).

✅ Conclusion:
CircuitBreaker + Bulkhead combination:

Protects service from overload.
Counts concurrent call rejections as failures.
Opens circuit if failure threshold exceeded.
Ensures system stability even under high load and partial failures.


Note:-

personal observation:-

1> we can use bulkahead indivisually on method but it just block the further call as we define limit
2> use bulkahead with circuitBreaker it trigger the circuit open when failure % reach
3> we can not test it via multiple tab of chrome we have to use tool which do cuncurrent call
   if we do with tab's browser it is sequencial call.
   sequencial call != cuncurrent call
   cuncurrent is call like every call reach server at same time.
	
	*/
}
