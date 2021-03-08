package com.task.product_management.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@IdClass(PriceId.class)
@Table(name = "prices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    @Id
    @NonNull
    @OneToOne(fetch = FetchType.EAGER)
    private Currency currency;
    @NonNull
    private BigDecimal value;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price = (Price) o;
        return currency.equals(price.currency) &&
                value.equals(price.value) &&
                product.getId() == price.product.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, value, product);
    }

    @Override
    public String toString() {
        return "Price{" +
                "currency=" + currency+
                ", value=" + value +
                ", product=" + product.getId() +
                '}';
    }
}
