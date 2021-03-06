package com.task.product_management.model;

import java.io.Serializable;
import java.util.Objects;

public class NameAndDescriptionId implements Serializable {
    private Language language;
    private Product product;

    public NameAndDescriptionId(Language language, Product product) {
        this.language = language;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NameAndDescriptionId)) return false;
        NameAndDescriptionId that = (NameAndDescriptionId) o;
        return language.equals(that.language) &&
                product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, product);
    }
}
