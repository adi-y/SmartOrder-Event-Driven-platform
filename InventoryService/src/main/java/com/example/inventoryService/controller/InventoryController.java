package com.example.inventoryService.controller;

import com.example.inventoryService.model.Inventory;
import com.example.inventoryService.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping
    public Inventory addProduct(@RequestBody Inventory inventory){return inventoryService.addProduct(inventory);}

    @GetMapping("/{id}")
    public Optional<Inventory> getInventoryById(@PathVariable Long id){return inventoryService.getInventoryById(id);}

    @PutMapping("/{id}/update-quantity")
    public Inventory updateQuantity(@PathVariable Long id, @RequestParam int quantity){return inventoryService.updateQuantity(id, quantity);}
}
