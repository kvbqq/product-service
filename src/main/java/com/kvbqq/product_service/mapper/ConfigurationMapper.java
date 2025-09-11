package com.kvbqq.product_service.mapper;

import com.kvbqq.product_service.model.Configuration;
import com.kvbqq.product_service.model.ConfigurationDto;
import com.kvbqq.product_service.model.CreateConfigurationCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConfigurationMapper {
    ConfigurationDto toDto(Configuration configuration);

    Configuration toEntity(CreateConfigurationCommand command);
}
