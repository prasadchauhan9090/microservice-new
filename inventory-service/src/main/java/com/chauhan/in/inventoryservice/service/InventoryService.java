package com.chauhan.in.inventoryservice.service;


import com.chauhan.in.inventoryservice.model.Inventory;
import com.chauhan.in.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {


    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    private final InventoryRepository inventoryRepository;


   @Transactional(readOnly = true)
    public boolean isInStock(String skuCode)
    {
       return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
