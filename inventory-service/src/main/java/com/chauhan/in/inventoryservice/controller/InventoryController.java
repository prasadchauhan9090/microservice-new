package com.chauhan.in.inventoryservice.controller;


import com.chauhan.in.inventoryservice.model.Inventory;
import com.chauhan.in.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku-code") String skucode) {
      return  inventoryService.isInStock(skucode);

    }



}
