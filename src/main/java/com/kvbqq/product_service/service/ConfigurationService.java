package com.kvbqq.product_service.service;

import com.kvbqq.product_service.exception.ConfigurationNotFoundException;
import com.kvbqq.product_service.model.Configuration;
import com.kvbqq.product_service.repository.ConfigurationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfigurationService {
    private final ConfigurationRepository repository;

    public List<Configuration> getConfigurations(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    public Configuration getConfigurationById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ConfigurationNotFoundException("Configuration with given id does not exist"));
    }

    public Configuration createConfiguration(Configuration configuration) {
        return repository.save(configuration);
    }

    public void removeConfigurationById(Long id) {
        Configuration configuration = repository.findById(id)
                .orElseThrow(() -> new ConfigurationNotFoundException("Configuration with given id does not exist"));

        repository.delete(configuration);
    }

    public Configuration updateConfiguration(Long id, Configuration configuration) {
        Configuration existingConfiguration = repository.findById(id)
                .orElseThrow(() -> new ConfigurationNotFoundException("Configuration with given id does not exist"));
        existingConfiguration.update(configuration);

        return repository.save(existingConfiguration);
    }
}
