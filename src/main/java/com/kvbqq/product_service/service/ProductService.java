package com.kvbqq.product_service.service;

import com.kvbqq.product_service.exception.ProductNotFoundException;
import com.kvbqq.product_service.exception.ProductTypeNotFoundException;
import com.kvbqq.product_service.model.Product;
import com.kvbqq.product_service.model.ProductType;
import com.kvbqq.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product> getProducts(Pageable pageable, String type) {
        return type != null ? repository.findByType(pageable, ProductType.from(type)).getContent() : repository.findAll(pageable).getContent();
    }

    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with given id does not exist"));
    }

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public void removeProductById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with given id does not exist"));

        repository.delete(product);
    }
}
