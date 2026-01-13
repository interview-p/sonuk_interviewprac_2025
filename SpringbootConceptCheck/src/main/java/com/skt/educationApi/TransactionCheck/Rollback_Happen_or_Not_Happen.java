package com.skt.educationApi.TransactionCheck;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class Rollback_Happen_or_Not_Happen {

	private final UserRepository userRepository;

    public Rollback_Happen_or_Not_Happen(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void createUser(String name) {
        User user = new User(name);
        userRepository.save(user);

        // no exception → transaction will COMMIT
        System.out.println("User saved: " + name);
    }
    
    @Transactional
    public void rollback_Happen(String name) {
    	    User user = new User(name);
        userRepository.save(user);
        throw new RuntimeException("boom");
        
        // in this method we throw uncheckException which ecapse the method due to 
        // transaction not commit the change
    }
    
    @Transactional
    public void rollbackHappenCheckedException(String name) throws Exception {
    	    User user = new User(name);
        userRepository.save(user);
        throw new Exception("checked");
        
        // in this method we throw checkException which ecapse the method still
        // rollback not happen only for uncheckexception
    }
    
    @Transactional(rollbackFor = { Exception.class })
    public void rollback_Happen_With_CheckException(String name) throws Exception {
    	    User user = new User(name);
        userRepository.save(user);
        throw new Exception("checked");
        
       /*
        * in this case we throw checkException and rollback happen because we forcefully
        * mention "rollbackFor" inside Transaction parameter
        */
    }
    
    // when commit and rollback not happen
    @Transactional
    public void rollback_not_happen_swallow(String name) {
        try {
            	User user = new User(name);
            userRepository.save(user);
            throw new RuntimeException();
        } catch (Exception e) {
        	   System.out.print("message ="+e);
            // swallowed
        }
        
        /*
         * commit happen roleback not happen because unchecexception swallow by 
         * cache block
         */
    }
   
    // commit not work due to self-invocation
    public void self_invocation(String name) {
        save(name); // ❌ proxy NOT used
        // roleback not happe because due to self invocation transaction not work
    }

    @Transactional
    public void save(String name) {
    	    User user = new User(name);
        userRepository.save(user);
        throw new RuntimeException();
    }

}
