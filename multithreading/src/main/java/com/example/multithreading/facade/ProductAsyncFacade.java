package com.example.multithreading.facade;

import com.example.multithreading.dto.ProductDetailDTO;
import com.example.multithreading.entity.Inventory;
import com.example.multithreading.entity.Price;
import com.example.multithreading.entity.Product;
import com.example.multithreading.service.InventoryService;
import com.example.multithreading.service.PriceService;
import com.example.multithreading.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
@Component
public class ProductAsyncFacade {

    @Autowired
    private ProductService productService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private PriceService priceService;

    public CompletableFuture<Product> getProductById(long productId) {
        return CompletableFuture
                .supplyAsync(() -> productService.findById(productId));
    }

    public CompletableFuture<Price> getPriceByProductId(long productId) {
        return CompletableFuture
                .supplyAsync(() -> priceService.getPriceByProductId(productId));
    }

    public CompletableFuture<Inventory> getInventoryByProductId(long productId) {
        return CompletableFuture
                .supplyAsync(() -> inventoryService.getInventoryByProductId(productId));
    }

    // Asynchronous method to fetch product details
    public ProductDetailDTO getProductDetails(long productId) {

       //fetch all async
       CompletableFuture<Product> productFuture =  getProductById(productId);
       CompletableFuture<Price> priceFuture = getPriceByProductId(productId);
       CompletableFuture<Inventory> inventoryFuture = getInventoryByProductId(productId);

       // wait for all futures to complete
       CompletableFuture.allOf(productFuture, priceFuture, inventoryFuture);

       //combine the result
       Product product = productFuture.join();
       Price price = priceFuture.join();
       Inventory inventory = inventoryFuture.join();

       //build and return

        return new ProductDetailDTO(
                productId,
                product.getCategory().getName(),
                product.getName(),
                product.getDescription(),
                inventory.getAvailableQuantity(),
                price.getPrice(),
                inventory.getStatus());

    }

}
