package com.example.multithreading.service.impl;

import com.example.multithreading.entity.Price;
import com.example.multithreading.repository.PriceRepository;
import com.example.multithreading.service.PriceService;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price getPriceByProductId(Long productId) {
        // Simulating a delay to mimic a real-world scenario
        addDelay();
        return priceRepository.findByProductId(productId);
    }

    private void addDelay() {
        try {
            // adding 1s delay
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
