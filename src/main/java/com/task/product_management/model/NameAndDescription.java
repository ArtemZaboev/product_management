package com.task.product_management.model;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(NameAndDescriptionId.class)
@Table(name = "name_description")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NameAndDescription {

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    @Id
    @OneToOne
    @Fetch(FetchMode.SELECT)
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
        return product.getId() == that.product.getId() &&
                language.equals(that.language) &&
                name.equals(that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, language, name, description);
    }

    @Override
    public String toString() {
        return "NameAndDescription{" +
                "product=" + product.getId() +
                ", language=" + language.getName() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
