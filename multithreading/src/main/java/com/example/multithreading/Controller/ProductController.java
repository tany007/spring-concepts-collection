package com.example.multithreading.Controller;

import com.example.multithreading.dto.ProductDetailDTO;
import com.example.multithreading.facade.ProductAsyncFacade;
import com.example.multithreading.facade.ProductSyncFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductSyncFacade productSyncFacade;

    @Autowired
    private ProductAsyncFacade productAsyncFacade;

    @GetMapping("{id}/sync")
    public ResponseEntity<ProductDetailDTO> getProductSync(@PathVariable Long id) {
        log.info("Fetching product details synchronously for product ID: {}", id);
        ProductDetailDTO productDetail = productSyncFacade.getProductDetails(id);
        return ResponseEntity.ok(productDetail);
    }

    @GetMapping("{id}/async")
    public ResponseEntity<ProductDetailDTO> getProductAsync(@PathVariable Long id) {
        log.info("Fetching product details asynchronously for product ID: {}", id);
        ProductDetailDTO productDetail = productAsyncFacade.getProductDetails(id);
        return ResponseEntity.ok(productDetail);
    }

}
