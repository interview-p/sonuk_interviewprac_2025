package com.graphql.graphqlTest;

public class Notes {

	/*
	GraphQL is a query language and is not the same as RestTemplate. In RestTemplate, 
	we pass a list of attributes and get a response based on the predefined response model. 
	In GraphQL, we specify the data we need directly in the query, and the backend returns only 
	that data. This allows us to fetch multiple pieces of related data in a single request,
	 reducing the need for multiple REST calls and, consequently, lowering computation and CPU 
	 usage.
	 
	 termology:-
	 
	 1> Schema(the file schema.graphql created in resources folder)
	    Definition: The schema is the blueprint of your GraphQL API.
	    schema declares the entry points (query and mutation) for the API
	    Schema ensures type safety for clients
	    it is basically contract between client and server in form of query(fetch data) and mutation(save data)
	    
	    
	 2> Type:-
	    Schema ensures type safety for clients
	    Scalar type – basic types like Int, Float, String, Boolean, ID
	    Object type – a user-defined type like User, Order, Payment
	    Input type – used for passing complex arguments to mutations
	    
	    Schema → Like the menu of a restaurant (what you can order).
        Type → Like a recipe for a dish (what ingredients/fields it contains)
        
        
	 3> Type modifiers
	    Definition: Type modifiers are symbols added to a type in GraphQL to specify nullability or list behavior
	    They help control whether a value is required or optional, and whether it’s a single value or a list
	    
	    ! -> not null
	    [] -> list 
	       [Int!] - inside any element of list can not be null eg. ['a','b',null] - null not accepted
	                [] - accepted
	       [Int]! - list can not be blank - > [] not accepted ["a","b"] - accepeted
	       [Int!]! - list not null and inside any not null
	       
	  4> Enum types
	  
	  
	  5> Interface types
	  
	  6> Union types
	  
	  7> Input Object types
	  
	  8> Directives
	       
	       
	
	
	
	*/
}
