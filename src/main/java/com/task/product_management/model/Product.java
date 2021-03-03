package com.task.product_management.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private long id;
    @NonNull
    private String name;
    private String description;

    private BigDecimal price;
    private Instant createDate;
    private Instant updateDate;

    public Product(String name, String description, BigDecimal price, Instant createDate) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id &&
                name.equals(product.name) &&
                description.equals(product.description) &&
                price.equals(product.price) &&
                Objects.equals(createDate,product.createDate) &&
                Objects.equals(updateDate, product.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, createDate, updateDate);
    }
}
