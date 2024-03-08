package com.microservicetutorial.inventoryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicetutorial.inventoryservice.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	List<Inventory> findBySkucodeIn(List<String> skuCode);

}
