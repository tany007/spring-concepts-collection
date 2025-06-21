package com.example.multithreading.service;

import com.example.multithreading.entity.Inventory;

public interface InventoryService {
    Inventory getInventoryByProductId(Long productId);
}
