package com.example.asynchronous.service;

import com.example.asynchronous.dto.Order;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public void processPayment(Order order) {
        // Simulate payment processing
        System.out.println("Processing payment for Order ID: " + order.getOrderId() +
                ", Product: " + order.getProductName() +
                ", Amount: $" + order.getPrice());
    }
}
