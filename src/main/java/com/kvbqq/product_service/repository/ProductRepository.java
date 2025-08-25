package com.kvbqq.product_service.repository;

import com.kvbqq.product_service.model.Product;
import com.kvbqq.product_service.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByType(Pageable pageable, ProductType type);
}
