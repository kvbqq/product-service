package com.kvbqq.product_service.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends ProductServiceException {
    public ProductNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
