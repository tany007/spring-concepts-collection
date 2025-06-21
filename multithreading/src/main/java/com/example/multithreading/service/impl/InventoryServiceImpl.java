package com.example.multithreading.service.impl;

import com.example.multithreading.entity.Inventory;
import com.example.multithreading.repository.InventoryRepository;
import com.example.multithreading.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory getInventoryByProductId(Long productId) {
        log.info("Getting inventory for the productId {}", productId);
        addDelay();
        return inventoryRepository.findByProductId(productId);
    }

    private void addDelay() {
        try {
            // adding 2s delay
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
