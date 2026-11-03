package com.chauhan.in.inventoryservice.repository;

import com.chauhan.in.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface InventoryRepository extends JpaRepository<Inventory, Long> {


    Optional<Inventory> findBySkuCode(String skuCode);

    // Optional<Object> findBySkuCode(String skuCode);
}

