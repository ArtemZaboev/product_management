package com.task.product_management.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@IdClass(PriceId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Price {

    @Id
    @NonNull
    @OneToOne(fetch = FetchType.EAGER)
    private Currency currency;
    @NonNull
    private BigDecimal value;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price = (Price) o;
        return currency.equals(price.currency) &&
                value.equals(price.value) &&
                product.equals(price.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, value, product);
    }
}
