package com.orch.saga.Orchestration_InventoryService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orch.saga.Orchestration_InventoryService.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, String>{

}
