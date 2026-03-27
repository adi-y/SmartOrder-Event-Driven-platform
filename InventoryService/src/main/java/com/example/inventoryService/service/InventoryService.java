    package com.example.inventoryService.service;

    import com.example.inventoryService.InventoryStatus;
    import com.example.inventoryService.model.Inventory;

    import java.util.Optional;

    public interface InventoryService {
        Inventory addProduct(Inventory inventory);

        Optional<Inventory> getInventoryById(Long id);

        Inventory updateQuantity(Long productId, int quantity);
    }
