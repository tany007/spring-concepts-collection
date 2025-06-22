package com.example.asynchronous.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private int orderId;
    private int productId;
    private String productName;
    private int quantity;
    private double price;
    private String trackingNumber;
}
