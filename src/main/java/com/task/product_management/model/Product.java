package com.task.product_management.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @NonNull
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference
//    @Fetch(FetchMode.SELECT)
//    @BatchSize(size = 10)
    private List<NameAndDescription> name_description;

//    @NonNull
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference
//    @Fetch(FetchMode.SELECT)
//    @BatchSize(size = 10)
    private List<Price> prices;

    @NonNull
    @Column(name = "create_data")
    private Instant createDate;

    @NonNull
    @Column(name = "update_data")
    private Instant updateDate;

    public Product(List<NameAndDescription> name_description, List<Price> prices, Instant createDate, Instant updateDate) {
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
                ", name_description=" + name_description+
                ", prices=" + prices +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
