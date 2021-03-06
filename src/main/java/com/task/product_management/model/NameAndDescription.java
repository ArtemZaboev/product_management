package com.task.product_management.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(NameAndDescriptionId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NameAndDescription {

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Id
    @OneToOne(fetch = FetchType.EAGER)
    @NonNull
    private Language language;

    @NonNull
    private String name;

    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NameAndDescription)) return false;
        NameAndDescription that = (NameAndDescription) o;
        return product.equals(that.product) &&
                language.equals(that.language) &&
                name.equals(that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, language, name, description);
    }
}
