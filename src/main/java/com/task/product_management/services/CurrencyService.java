package com.task.product_management.services;

import com.task.product_management.model.Currency;

import java.util.Set;

public interface CurrencyService {
    Currency addCurrency(Currency currency);

    void deleteCurrencyByName(String currency_name);

    boolean currencyExistsByName(String currency_name);

    Set<Currency> getAllCurrencies();

    Currency getCurrencyByName(String currencyName);
}
