package com.example.multithreading.facade;

import com.example.multithreading.dto.ProductDetailDTO;
import com.example.multithreading.entity.Inventory;
import com.example.multithreading.entity.Price;
import com.example.multithreading.entity.Product;
import com.example.multithreading.service.InventoryService;
import com.example.multithreading.service.PriceService;
import com.example.multithreading.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductSyncFacade {

    @Autowired
    private ProductService productService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private PriceService priceService;

    public ProductDetailDTO getProductDetails(long productId) {
        log.info("Sync facade product details for product ID: {}", productId);
        Product product = productService.findById(productId);

        Price price = priceService.getPriceByProductId(productId);

        Inventory inventory = inventoryService.getInventoryByProductId(productId);

        return new ProductDetailDTO(productId, product.getCategory().getName(), product.getName(),
                product.getDescription(), inventory.getAvailableQuantity(), price.getPrice(), inventory.getStatus());

    }
}
