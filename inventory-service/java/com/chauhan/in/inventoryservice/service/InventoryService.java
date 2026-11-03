package com.chauhan.in.inventoryservice.service;


import com.chauhan.in.inventoryservice.dto.InventoryResponse;
import com.chauhan.in.inventoryservice.model.Inventory;
import com.chauhan.in.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryService {


    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    private final InventoryRepository inventoryRepository;


   @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode)
    {
       return inventoryRepository.findBySkuCodeIn(skuCode).stream()
               .map(inventory ->
                   InventoryResponse.builder()
                           .skuCode(inventory.getSkuCode())
                           .isInStock(inventory.getQuantity() > 0)
                           .build()

               ).toList();
    }
}
