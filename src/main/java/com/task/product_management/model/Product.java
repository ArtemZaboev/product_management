package com.task.product_management.model;

import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
//    @Fetch(FetchMode.SELECT)
//    @BatchSize(size = 10)
    private Set<NameAndDescription> name_description;

    @NonNull
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
//    @Fetch(FetchMode.SELECT)
//    @BatchSize(size = 10)
    private Set<Price> prices;

    @NonNull
    private Instant createDate;

    @NonNull
    private Instant updateDate;

    public Product(Set<NameAndDescription> name_description, Set<Price> prices, Instant createDate, Instant updateDate) {
        this.name_description = name_description;
        this.prices = prices;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Product(Instant createDate, Instant updateDate) {
        this.createDate = createDate;
        this.updateDate = updateDate;
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
