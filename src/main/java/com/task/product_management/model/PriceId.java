package com.task.product_management.model;

import java.io.Serializable;
import java.util.Objects;

public class PriceId implements Serializable {
    private Currency currency;
    private Product product;

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
}
