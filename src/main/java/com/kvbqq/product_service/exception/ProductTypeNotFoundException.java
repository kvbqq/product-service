package com.kvbqq.product_service.exception;

public class ProductTypeNotFoundException extends RuntimeException {
    public ProductTypeNotFoundException(String message) {
        super(message);
    }
}
