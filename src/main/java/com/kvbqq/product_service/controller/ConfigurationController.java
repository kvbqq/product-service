package com.kvbqq.product_service.controller;

import com.kvbqq.product_service.mapper.ConfigurationMapper;
import com.kvbqq.product_service.model.ConfigurationDto;
import com.kvbqq.product_service.model.CreateConfigurationCommand;
import com.kvbqq.product_service.service.ConfigurationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/configurations")
public class ConfigurationController {
    private final ConfigurationService service;
    private final ConfigurationMapper mapper;

    @GetMapping
    public List<ConfigurationDto> getConfigurations(Pageable pageable) {
        log.info("Fetching configurations");

        return service.getConfigurations(pageable).stream()
                .map(mapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ConfigurationDto getConfigurationById(@PathVariable Long id) {
        log.info("Fetching configuration with id: {}", id);

        return mapper.toDto(service.getConfigurationById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConfigurationDto createConfiguration(@RequestBody CreateConfigurationCommand command) {
        log.info("Creating configuration with name: {}", command.getName());

        return mapper.toDto(service.createConfiguration(mapper.toEntity(command)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeConfigurationById(@PathVariable Long id) {
        log.info("Deleting configuration with id: {}", id);

        service.removeConfigurationById(id);
    }

    @PutMapping("/{id}")
    public ConfigurationDto updateConfiguration(@PathVariable Long id, @RequestBody CreateConfigurationCommand command) {
        log.info("Updating configuration with id: {}", id);

        return mapper.toDto(service.updateConfiguration(id, mapper.toEntity(command)));
    }
}
