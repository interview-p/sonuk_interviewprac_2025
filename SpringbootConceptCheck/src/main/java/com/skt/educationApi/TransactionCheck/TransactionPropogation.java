package com.skt.educationApi.TransactionCheck;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

@Service
public class TransactionPropogation {

	private final UserRepository userRepository;

    public TransactionPropogation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
  
    //--------transaction propogation - required
	@Transactional
	public void A(String name) {
	    B(name);
	    E(name);
	  //throw new RuntimeException("df");
	}

	@Transactional
	public void B(String name) {
		User user = new User(name+"B");
		userRepository.save(user);
		//throw new RuntimeException("df");
	}
	
	@Transactional
	public void E(String name) {
		User user = new User(name+"E");
		userRepository.save(user);
		//throw new RuntimeException("df");
	}
	
	/*
	 * here we call method B from method A and use @Transaction at both method if not use
	 * it will case of self-invocation and trsanction not work 
	 * here if exception throw from any one method trsanction from both method revoke
	 */
	
	//---------propogation - required_new
	
	

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void D(String name) {
		User user = new User(name+"D");
		userRepository.save(user);
		throw new RuntimeException("df");
	}
	
	/*
	 * method D call from method C which should be in external bean if both method in same
	 * bean it will not work
	 * here we can see in method C() we throw exception but still data saved in DB
	 */
	
	//---------------propogation - nested

	//@Transactional(propagation = Propagation.NESTED)
	@Transactional
	public void F(String name) {
		User user = new User(name+"F");
		userRepository.save(user);
		throw new RuntimeException("df");
	}
	
	//----------------propogation - support
	
	@Transactional
	public void write(String name) {
		User user = new User(name+"F");
		userRepository.save(user);
		throw new RuntimeException("df");
	}
	
	//------------SUPPORT----------------
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public void read(Long id) {
		Optional<User> usr = userRepository.findById(id);
		System.out.println("read data ="+usr.get().getName());
		//throw new RuntimeException("df");
	}
	
	//-------------not support
	
	@Transactional
	public void H(String name) {
		User user = new User(name+"H");
		userRepository.save(user);
		//throw new RuntimeException("df");
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void I(String name) throws InterruptedException {
		//Thread.sleep(5000);
		System.out.println("hai this not support read operation");
		throw new RuntimeException("df");
	}
	
	@Transactional
	public void J(String name) {
		User user = new User(name+"J");
		userRepository.save(user);
		//throw new RuntimeException("df");
	}
	
	/*
	 * here we use not_support which mean it reject existing transaction and method
	 * run with no transaction . it use basically in which situation when we want to
	 * if any non-db work like call rest api do some internal work
	 * 
	 * here what we observe H data saved successfully than 5 sec pause than J data save 
	 * mean when I goes into sleep H able to save data not effect on other method
	 * even if we through exception in I method it not effect other method H method
	 */
	
	//----------------Mandatory---------------------
	
	@Transactional
	public void K(String name) {
		User user = new User(name+"K");
		L(name);
		M(name);
		userRepository.save(user);
		//throw new RuntimeException("df");
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void L(String name) {
		User user = new User(name+"L");
		userRepository.save(user);
		//throw new RuntimeException("df");
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void M(String name) {
		User user = new User(name+"M");
		userRepository.save(user);
		throw new RuntimeException("df");
	}
	
	/*
	 * when we make any method as mandatory transaction -> it join the existing transaction
	 * . if existing trsansaction not found it throw exception and further program execution
	 * restrict
	 */
	
	//------------------NEVER-------------
	
	@Transactional(propagation = Propagation.NEVER)
	public void N(String name) {
		User user = new User(name+"N");
		userRepository.save(user);
		throw new RuntimeException("df");
	}
	
	/*
	 * Never -> it never join any transaction if we try to call N method from
	 * any transactional method it throw error. it should always call from 
	 * non-transactional method
	 */
	
}
