package com.kvbqq.product_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ConfigurationDto {
    private Long id;
    private Long productId;
    private String name;
    private String type;
    private BigDecimal price;
}
