package com.example.multithreading.service;

import com.example.multithreading.entity.Price;

public interface PriceService {
    Price getPriceByProductId(Long productId);
}
