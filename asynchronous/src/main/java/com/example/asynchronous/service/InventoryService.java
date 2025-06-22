package com.example.asynchronous.service;

import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    public boolean checkProductAvailability(int productId, int quantity) {
        // Simulate checking product availability
        // In a real application, this would involve checking a database or an external service
        System.out.println("Checking availability for product ID: " + productId + ", Quantity: " + quantity);

        // For simplicity, let's assume the product is always available
        return true;
    }
}
