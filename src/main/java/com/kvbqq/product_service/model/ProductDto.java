package com.kvbqq.product_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private ProductType type;
    private BigDecimal price;
    private Integer stock;
    private List<ConfigurationDto> configurations;
}
