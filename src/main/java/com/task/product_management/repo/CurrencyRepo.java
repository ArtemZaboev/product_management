package com.task.product_management.repo;

import com.task.product_management.model.Currency;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Set;

public interface CurrencyRepo extends PagingAndSortingRepository<Currency, Long> {
    boolean existsByName(String currencyName);

    void deleteByName(String currencyName);

    Set<Currency> findAll();

    Currency findByName(String currencyName);
}
