package com.skt.educationApi.beanscope.request;

public class notes {

	/*
	request->
	
	A bean with request scope is created once per HTTP request.
    It is destroyed automatically when the request completes.
    
    When a request comes, DispatcherServlet creates a RequestAttributes object tied to current thread.
    RequestScope is registered in WebApplicationContext.
    When a request-scoped bean is accessed:
    Proxy asks the RequestScope for the current bean instance.
    If none exists, it creates a new one and stores it in the request attributes.
    Destroyed automatically at the end of request.
    
    usecase--------------
    
    Request-scoped beans are not for sharing state across requests.
    Great for:
    Request correlation IDs
    Request-specific metadata (like client IP, headers)
    Logging/tracing
    Temporary user input before persistence
	
	*/
}
