package com.kvbqq.product_service.model;

import com.kvbqq.product_service.exception.ProductTypeNotFoundException;

import java.util.Locale;

public enum ProductType {
    COMPUTER, SMARTPHONE, ELECTRONICS;

    public static ProductType from(String type) {
        try {
            return ProductType.valueOf(type.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException ex) {
            throw new ProductTypeNotFoundException("Unknown product type: " + type);
        }
    }
}
