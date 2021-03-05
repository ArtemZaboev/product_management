package com.task.product_management.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    @OneToMany(mappedBy = "product")
    private Set<NameDescription> name_description=new HashSet<>();

    @NonNull
    @OneToMany(mappedBy = "product" )
    private Set <Price> prices=new HashSet<>();
    @NonNull
    private Instant createDate;
    @NonNull
    private Instant updateDate;

    public Product(Set<NameDescription> name_description, Set<Price> prices, Instant createDate, Instant updateDate) {
        this.name_description=name_description;
        this.prices = prices;
        this.createDate = createDate;
        this.updateDate=updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                name_description.equals(product.name_description) &&
                prices.equals(product.prices) &&
                createDate.equals(product.createDate) &&
                updateDate.equals(product.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name_description, prices, createDate, updateDate);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
