package com.task.product_management.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NameAndDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

    @OneToOne
    @NonNull
    private Language language;
    @NonNull
    private String name;

    private String description;

    public NameAndDescription(Product product,Language language, String name, String description) {
        this.product=product;
        this.language=language;
        this.name=name;
        this.description=description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NameAndDescription)) return false;
        NameAndDescription that = (NameAndDescription) o;
        return id == that.id &&
                product.equals(that.product) &&
                language.equals(that.language) &&
                name.equals(that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, language, name, description);
    }
}
