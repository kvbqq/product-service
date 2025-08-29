package com.kvbqq.product_service.exception;

import com.kvbqq.product_service.model.ApiError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {
    @ExceptionHandler(ProductServiceException.class)
    public ResponseEntity<ApiError> handleGithubProxyException(ProductServiceException ex) {
        return ResponseEntity.status(ex.getStatus())
                .body(new ApiError(ex.getStatus(), ex.getMessage()));
    }
}
