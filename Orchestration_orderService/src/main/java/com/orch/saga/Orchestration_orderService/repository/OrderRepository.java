package com.orch.saga.Orchestration_orderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orch.saga.Orchestration_orderService.Entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String>{

}
