package com.kvbqq.product_service.controller;

import com.kvbqq.product_service.mapper.ProductMapper;
import com.kvbqq.product_service.model.CreateProductCommand;
import com.kvbqq.product_service.model.ProductDto;
import com.kvbqq.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;
    private final ProductMapper mapper;

    @GetMapping
    public List<ProductDto> getProducts(Pageable pageable, @RequestParam(required = false) String type) {
        log.info("Fetching products");

        return service.getProducts(pageable, type).stream()
                .map(mapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        log.info("Fetching product with id: {}", id);

        return mapper.toDto(service.getProductById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createProduct(@RequestBody CreateProductCommand command) {
        log.info("Creating product with name: {}", command.getName());

        return mapper.toDto(service.createProduct(mapper.toEntity(command)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProductById(@PathVariable Long id) {
        log.info("Deleting product with id: {}", id);

        service.removeProductById(id);
    }
}
