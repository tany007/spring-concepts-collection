package com.example.multithreading.service;

import com.example.multithreading.entity.Product;

public interface ProductService {
    Product findById(Long id);
}
