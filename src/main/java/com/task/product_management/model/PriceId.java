package com.task.product_management.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

public class PriceId implements Serializable {
    @Getter
    @Setter
    private Currency currency;
    @Getter
    @Setter
    @JsonBackReference
    private Product product;

    public PriceId() {
    }

    public PriceId(Currency currency, Product product) {
        this.currency = currency;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriceId)) return false;
        PriceId priceId = (PriceId) o;
        return currency.equals(priceId.currency) &&
                product.equals(priceId.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, product);
    }

    @Override
    public String toString() {
        return "PriceId{" +
                "currency=" + currency.getName() +
                ", product=" + product.getId() +
                '}';
    }
}
