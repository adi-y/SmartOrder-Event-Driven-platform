package com.example.inventoryService.model;


import com.example.inventoryService.InventoryStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "inventory")
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productId;

    @CreationTimestamp
    LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    InventoryStatus status = InventoryStatus.AVAILABLE;

    String productName;
    String productDescription;
    String category;

    int availableQuantity;
    int reservedQuantity;
    int lowStackThreshold;

    String warehouseLocation;

    Double costPrice;
    Double sellingPrice;



}
