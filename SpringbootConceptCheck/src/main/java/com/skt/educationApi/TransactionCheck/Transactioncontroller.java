package com.skt.educationApi.TransactionCheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skt.educationApi.beanscope.singleton.OrderService;

@RestController
@RequestMapping("/transaction")
public class Transactioncontroller {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TransactionPropogation tranPropogation;

	@Autowired
	private Rollback_Happen_or_Not_Happen userService;
	
	 @GetMapping("/create")
	    public String create(@RequestParam String name) {
	        userService.createUser(name);
	        return "User created";
	    }
	    
	    @GetMapping("/rollback")
	    public String rollbackcheck(@RequestParam String name) {
	    	   try {
	        userService.rollback_Happen(name);
	    	   }
	    	   catch(Exception e) {
	    		   
	    	   }
	        return "rollback successful";
	    }
	    
	    //
	    @GetMapping("/rollbacknothappencheckException1")
	    public String rollbacknothappencheck(@RequestParam String name) {
	    	   try {
	        userService.rollbackHappenCheckedException(name);
	    	   }
	    	   catch(Exception e) {
	    		   System.out.print("message ="+e);
	    	   }
	        return "rollbacknothappen successful";
	    }
	    
	    @GetMapping("/rollbackhappencheckexception2")
	    public String rollback_Happen_With_CheckException(@RequestParam String name) {
	    	   try {
	        userService.rollback_Happen_With_CheckException(name);
	    	   }
	    	   catch(Exception e) {
	    		  System.out.print("message ="+e); 
	    	   }
	        return "rollbacknothappen successful";
	    }
	    
	    @GetMapping("/rollbacknothappenswallow3")
	    public String rollback_nothappen_swallow(@RequestParam String name) {
	    	   try {
	        userService.rollback_not_happen_swallow(name);
	    	   }
	    	   catch(Exception e) {
	    		   
	    	   }
	        return "rollbackhappen successful";
	    }
	    
	    @GetMapping("/rollbacknothappenselfinvocation4")
	    public String self_invocation(@RequestParam String name) {
	    	   try {
	        userService.self_invocation(name);
	    	   }
	    	   catch(Exception e) {
	    		   
	    	   }
	        return "rollbacknothappen successful";
	    }
	   
//-----------transaction propogation--------------------------------------------------
	    
	    //----------TRANSACTION REQUIRED-------------
	
	   
	    @GetMapping("/tranrequired/{name}")
	    public String tranRequiredCheck(@PathVariable String name) {
	    	   try {
	    		   tranPropogation.A(name);
	    	   }
	    	   catch(Exception e) {
	    		   
	    	   }
	        return "rollbacknothappen successful";
	    }
	  
	    //----------------TRANSACTION NEW-------------
	    @GetMapping("/tranrequirednew/{name}")
	    public String tranNew_RequiredCheck(@PathVariable String name) {
	    	   try {
	    		   C(name);
	    		   
	    	   }
	    	   catch(Exception e) {
	    		   
	    	   }
	        return "rollbacknothappen successful";
	    }
	   
	    @Transactional
		public void C(String name) {
	    	tranPropogation.D(name);
		  //throw new RuntimeException("df");
		}
	
	    //---------------------NESTED-------
	    
	    @GetMapping("/tranrequirednested/{name}")
	    public String tranRequiredNestedCheck(@PathVariable String name) {

	      	  A1(name);
	    	   
	    	  
	        return "rollbacknothappen successful";
	    }
	    
	    @Transactional
	    public void A1(String name){
	    	
	    	       tranPropogation.B(name);
	      	   try {
	           tranPropogation.F(name);
	      	   }
	      	   catch(Exception e) {
	      		   
	      	   }
	           tranPropogation.E(name);
	    }
	    
	    /*
	     * here we call B(exception not throw) than F(throw exception) than E 
	     * method we mark F method as nested 
	     * and throw exception in F method . when we run this code
	     * B data will save but F and E will not save because exception propogate
	     * here . so we create one savepoint after F and use F in try catch so exception 
	     * catch and method E data saved 
	     * 
	     * here if we use Required_new in F method exception not propogate till E method
	     * do not catch F method exception
	     * 
	     * Required/Nested -> if we use nested in F and do not use try catch
	     * method B data will save F and E data will not save. if we required in all
	     * method data all method data revoke
	     * 
	     * in simple word if we use nested in F method and throw exception . method
	     * use before F commited successfully but after F method rest of Method data 
	     * will not save
	     */
	    
	    //------------------SUPPORT--------
	    
	    
	    @GetMapping("/transupport/{name}")
	    public String tranSupportCheck(@PathVariable String name) {

	      	  A2(name);
	    	   
	    	  
	        return "rollbacknothappen successful";
	    }
	    
	    @Transactional
	    public void A2(String name) {
	    	
	      	tranPropogation.write(name);
	      	tranPropogation.read((long) 1);
	    }
	    
	    /*
	     * support propogation -> if transaction exist it will join same transaction if not
	     * it will not join 
	     * why important let's suppose we do write operation than read .what happen
	     * read operation do not read updated value because spring will not commit value under
	     * transaction untill method not completed successfully if value not committed data not 
	     * visiable in database if not visiable it will not seen updated value to read operation
	     * so in that case we use support propogation on read operation so that
	     * read join the same write-transaction. and read updated value
	     * 
	     * 
	     */
	    
	    //---------------NOT SUPPORT---------
	    
	    @GetMapping("/trannotsupport/{name}")
	    public String trannotSupportCheck(@PathVariable String name) throws InterruptedException {

	      	  A3(name);
	    	   
	    	  
	        return "rollbacknothappen successful";
	    }
	    
	    @Transactional
	    public void A3(String name) throws InterruptedException {
	    	
	    	  tranPropogation.H(name);
	      tranPropogation.I(name);
	      tranPropogation.J(name);
	    }
	    
	    //----------------------MANDATORY---------------
	    
	    @GetMapping("/trannotmandatory/{name}")
	    @Transactional
	    public String trannotMandatoryCheck(@PathVariable String name) throws InterruptedException {

	      	  //A4(name);
      	    tranPropogation.K(name);
	        return "rollbacknothappen successful";
	    }
	    
	    @Transactional
	    public void A4(String name) throws InterruptedException {
	    	
	      tranPropogation.L(name);
	    }
	    
	    //----------------------NEVER---------------------
	    
	    @GetMapping("/trannever/{name}")
	    //@Transactional
	    public String trannotNEVERCheck(@PathVariable String name) throws InterruptedException {

	      	A5(name);
      	    //tranPropogation.N(name);
	        return "rollbacknothappen successful";
	    }
	    
	    
	    @Transactional
	    public void A5(String name) throws InterruptedException {
	    	
	      tranPropogation.N(name);
	    }
	    
}
