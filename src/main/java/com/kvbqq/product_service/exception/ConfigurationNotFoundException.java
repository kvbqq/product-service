package com.kvbqq.product_service.exception;

import org.springframework.http.HttpStatus;

public class ConfigurationNotFoundException extends ProductServiceException {
    public ConfigurationNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
