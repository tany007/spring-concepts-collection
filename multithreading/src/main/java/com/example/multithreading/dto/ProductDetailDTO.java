package com.example.multithreading.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailDTO {

    private Long id;

    private String categoryName;

    private String productName;

    private String description;

    private Integer availableQuantity;

    private Double price;

    private String status;
}
