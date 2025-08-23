package com.kvbqq.product_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CreateProductCommand {
    private String name;
    private ProductType type;
    private BigDecimal price;
    private Integer stock;
}
