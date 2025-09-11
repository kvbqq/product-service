package com.kvbqq.product_service.mapper;

import com.kvbqq.product_service.model.CreateProductCommand;
import com.kvbqq.product_service.model.Product;
import com.kvbqq.product_service.model.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);

    Product toEntity(CreateProductCommand command);
}
