package com.example.inventoryService.service.Impl;

import com.example.inventoryService.model.Inventory;
import com.example.inventoryService.repo.InventoryRepo;
import com.example.inventoryService.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepo repo;

    @Override
    public Inventory addProduct(Inventory inventory){
        return repo.save(inventory);
    }

    @Override
    public Optional<Inventory> getInventoryById(Long id){
        return repo.findById(id);
    }

    @Override
    public Inventory updateQuantity(Long productId, int quantity){
        Inventory inventory = repo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        inventory.setAvailableQuantity(inventory.getAvailableQuantity() - quantity);
        inventory.setReservedQuantity(inventory.getReservedQuantity()+quantity);
        return repo.save(inventory);
    }
}
