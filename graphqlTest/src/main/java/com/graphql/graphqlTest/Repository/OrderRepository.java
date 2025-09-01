package com.graphql.graphqlTest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.graphqlTest.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	
}
