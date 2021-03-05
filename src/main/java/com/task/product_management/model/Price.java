package com.task.product_management.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    @OneToOne
    private Currency currency;
    @NonNull
    private BigDecimal value;
    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

    public Price(Product product,Currency currency,BigDecimal value) {
        this.product=product;
        this.currency=currency;
        this.value=value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price = (Price) o;
        return id == price.id &&
                currency.equals(price.currency) &&
                value.equals(price.value) &&
                product.equals(price.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currency, value, product);
    }


}
