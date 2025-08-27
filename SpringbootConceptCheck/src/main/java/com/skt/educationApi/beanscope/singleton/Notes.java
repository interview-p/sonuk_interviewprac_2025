package com.skt.educationApi.beanscope.singleton;

public class Notes {

	/*
	 * 1> Logger service is created when applicationContext start once and it can use across all application
	 * 
	 * 2> Logging is a stateless operation (you don’t need a new logger object for every request).
       So, a singleton bean is perfect.
	 * 
	 * 3> bad example - in ecomerse website let create one shopping cart class which is singleton 
	 *                  in that case user1 add item in cart and another user use same object 
	 *                  if another user remove the item from cart it remove for other user also
	 *                  her we can use "session bean scope or prototype bean scope.
	 *                  
	 * 4> usecase - for loggin, for configuration(database configuration), external tool connection
	 * 
	 * 
	 *                  
	 */
}
