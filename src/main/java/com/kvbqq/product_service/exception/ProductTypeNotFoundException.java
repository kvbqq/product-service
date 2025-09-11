package com.kvbqq.product_service.exception;

import org.springframework.http.HttpStatus;

public class ProductTypeNotFoundException extends ProductServiceException {
    public ProductTypeNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
