package com.graphql.graphqlTest.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.graphqlTest.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	  Optional<Payment> findByOrderId(Integer orderId);
}
