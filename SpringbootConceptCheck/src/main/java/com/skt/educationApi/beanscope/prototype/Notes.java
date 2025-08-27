package com.skt.educationApi.beanscope.prototype;

public class Notes {

	/*
	 * 1> prototype is kind of bean we creation when it called
	 * 
	 * 2> Use ObjectFactory, ObjectProvider, or @Lookup to get fresh prototype instances when needed.
	 * 
	 * 3> if we call prototype bean inside singleton bean it create only one object when we call
	 *    prototype class it return same object
	 * 4> here in this example we are creating token class which is type of prototype which is call
	 *    inside authservice class whenever we call tokengenerator it return different object which the 
	 *    help of objectprovider class
	 *    
	 * 5> lifecycle of bean -> when we create bean object created but it will distroy by springboot
	 *                         springboot let you decide to manage or when you will distroy the bean
	 *                         if we do not destroy jvm gc will ustomatically desctory it becoz bean
	 *                         not refer by any other reference variable
	 *                         
	 *                         if we don't want jvm gc delete it we have to store somewhere like in this example
	 *                         we store in map
	 *                         
	 * 6> objectprovider and @lookup - 
	 * 
	 *      1> ObjectProvider is like a lazy bean factory:
	 *      2> It gives you on-demand access to beans of type T
	 *      3> Every time you call getObject(), Spring creates (or fetches) a bean.
	 *      4> Works perfectly with prototype beans because each call gives a new instance.
	 *      
	 *     @lookup -
	 *     
	 *      1> @Lookup is used on an abstract or overridable method inside a singleton bean.
	 *      2> Spring generates a subclass at runtime and overrides the annotated method.
	 *      3> Each call to the method returns a new bean instance (good for prototype beans).
	 *      4> lookup use cglib which create one proxy object of prototype object and create refine
	 *         method annotated with lookup it create object of type what we mentation return type of
	 *         method . doesn't effect if we return null
	 *  
	 *  7> it is stateful
	 *  
	 *  8> here token generation happen only we can do it in simple way think if token is 
	 *     depend on userdetail and some secretkey mean usertoken class maintain some state
	 *     if we use same object for other user and somehow manupulate data it effect other user
	 *     
	 *  9> other example of shopping cart	
	 * 
	 * 
	 * 
	 */
}
