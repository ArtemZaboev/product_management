package com.task.product_management.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String name;

    public Language(String name) {
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Language)) return false;
        Language language = (Language) o;
        return id == language.id &&
                name.equals(language.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
