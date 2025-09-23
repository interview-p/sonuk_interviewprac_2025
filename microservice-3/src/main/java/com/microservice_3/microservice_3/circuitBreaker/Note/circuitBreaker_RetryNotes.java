package com.microservice_3.microservice_3.circuitBreaker.Note;

public class circuitBreaker_RetryNotes {

	/*
	
1> Retry Basics

Purpose: Automatically retry failed remote calls.

Key properties:
maxAttempts: How many times to retry (including first call).
waitDuration: Delay between retry attempts.
enableExponentialBackoff: Optional, increases wait duration after each attempt.
Execution flow:
Retry is applied before CircuitBreaker.
Only triggered if the method throws an exception.
If all retries fail → retry fallback is executed.
CircuitBreaker counts the final outcome for sliding window evaluation.

2> Retry + CircuitBreaker Interaction

User hits API → Retry proxy wraps the call.
Retry attempts the call maxAttempts times with waitDuration delay.
If retries fail → retryFallback executes.
CircuitBreaker evaluates the final result of the call.
If failure threshold is exceeded → CB opens → future calls skip retry → cbFallback executes immediately.
Actuator endpoints capture events only if retry actually executes and CB allows the call.

3> Common pitfalls

Proxying issue: Method must be called via Spring-managed bean. Internal calls within same class bypass annotations.
Immediate success: If the first call succeeds, retry never runs → no retry events.
CircuitBreaker short-circuiting: If CB is OPEN, retries are skipped → no retry events.
Exception types: Retry only triggers for exceptions; ensure remote failures throw compatible exceptions.
Event visibility: Retry events appear in /actuator/retryevents only after retries occur.

retry machism prevent unnecessary fallback how it prevent - i attemp 5 time each attempt
as per our configuration in background system attempt three 3 to call third party service
if one call success in three and in secound user attempt 2 retry success and 1 failed it's mean
it's system is unstable(some time response come some time not) but completly not work it's mean
partially system is working if retry machism is not introduce circuit open and after fixed time
which set in properties we can hit so these type of situation handle by retry. 


	
	*/
}
