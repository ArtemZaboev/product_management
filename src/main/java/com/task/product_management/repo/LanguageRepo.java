package com.task.product_management.repo;

import com.task.product_management.model.Currency;
import com.task.product_management.model.Language;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Set;

public interface LanguageRepo extends PagingAndSortingRepository<Language,Long> {
    boolean existsByName(String languageName);
    void deleteByName(String languageName);
    Set<Language> findAll();
    Language findByName(String languageName);
}
