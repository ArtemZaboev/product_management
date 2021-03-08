package com.task.product_management.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

public class NameAndDescriptionId implements Serializable {
    @Getter
    @Setter
    private Language language;
    @Getter
    @Setter
    @JsonBackReference
    private Product product;

    public NameAndDescriptionId(Language language, Product product) {
        this.language = language;
        this.product = product;
    }

    public NameAndDescriptionId() {
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

    @Override
    public String toString() {
        return "NameAndDescriptionId{" +
                "language=" + language.getId() +
                ", product=" + product.getId() +
                '}';
    }
}
