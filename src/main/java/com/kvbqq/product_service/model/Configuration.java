package com.kvbqq.product_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
public class Configuration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private BigDecimal price;

    public void update(Configuration configuration) {
        this.name = configuration.getName();
        this.type = configuration.getType();
        this.price = configuration.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuration configuration = (Configuration) o;
        return id != null && id.equals(configuration.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
