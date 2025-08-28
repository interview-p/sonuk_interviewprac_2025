package com.skt.educationApi.springMVC;

public class Notes {

	/*
	spring mvc
	
	1> Model–View–Controller web framework built on top of the Spring container.
	2> Spring Container (ApplicationContext)
	   1> Manages beans, DI, lifecycle, scopes.
	   2> Core part of Spring Framework (not tied to web).
	   
	3> Spring MVC
	   1> A web layer that uses the Spring container for its beans.
	   2> Handles HTTP requests, routes them to controllers, binds request data to objects, and returns responses (HTML/JSON/etc).
	   3> Works on the DispatcherServlet → Controller(find controller bean) → Service → Repository pipeline -> return response.
	   4> Uses those beans to process HTTP requests and responses
	   
	   mvc mean -> controlling(get request map to wright path) v-> return some thing(json,text,html)
	               m -> kind of container where data comes in parameter of request
	               
	   what is model ->
	     In Spring MVC, the Model is just a map-like container (key → value pairs).
         It is used to pass data from the controller to the view.
	               
	    routing,model binding,view
	    
	    roting-->
	     1> spring MVC uses annotations like @RequestMapping, @GetMapping, @PostMapping.
	     2> The DispatcherServlet is the front controller — every request first goes here.
	        It consults the HandlerMapping to decide which method to invoke.
	        
	        
	     3> Model binding -->
	     
	         1> converting request data into Java objects automatically.
	         2> Uses HttpMessageConverters for JSON/XML into model
	         Spring MVC can take:

               Query params (?id=1)
               Form data (application/x-www-form-urlencoded)
               JSON body (application/json)
               Path variables (/users/42
               
         4> view(response rendering)
            1> what the user see as response
            2> spring mvc support ->
               1> JSON/XML → with @RestController or @ResponseBody.
               2> HTML pages → @controller using templates (Thymeleaf, JSP, FreeMarker). - if class
                               annotated with @controller and return like "hello" spring search 
                               hello.html in template folder
               3> Files → PDF, Excel, etc.
            3> Managed by ViewResolver.
            4> Uses the Model (attributes) to inject data into the view.
            
	   
	4> how @sessionAttribute and @modelAttribute work
	  
	   When you hit a request:
       DispatcherServlet → delegates request to HandlerMapping → finds your Controller method.
       HandlerMethodArgumentResolver runs:
       For parameters annotated with @ModelAttribute (e.g. ShoppingCart cart):
       Checks if the attribute already exists:
       First in the Model (request scope).
       If not found, and controller is annotated with @SessionAttributes("cart"), Spring looks in HTTP Session.
       If still not found → creates a new instance (via default constructor) and puts it into the model.
       Session storage:
       When the method returns, Spring checks all model attributes.
       If any match the names or types in @SessionAttributes, Spring saves them into the HTTP session.
       Next request, Spring will fetch them back from session instead of creating again.
	
	
	*/
}
