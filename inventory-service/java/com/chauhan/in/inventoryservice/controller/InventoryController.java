package com.chauhan.in.inventoryservice.controller;


import com.chauhan.in.inventoryservice.dto.InventoryResponse;
import com.chauhan.in.inventoryservice.model.Inventory;
import com.chauhan.in.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skucode) {
      return  inventoryService.isInStock(skucode);

    }



}
