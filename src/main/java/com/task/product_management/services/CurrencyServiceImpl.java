package com.task.product_management.services;

import com.task.product_management.exception.TestException;
import com.task.product_management.model.Currency;
import com.task.product_management.repo.CurrencyRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service("CurrencyService")
@Slf4j
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepo currencyRepo;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepo currencyRepo) {
        this.currencyRepo = currencyRepo;
    }

    @Override
    public Currency addCurrency(Currency currency) {
        if (currencyExistsByName(currency.getName())) {
            log.info("Currency {} already exist.", currency.getName());
            //поменять на нормальное исключение!!!!!!!!!!!
            throw new TestException();
        }
        return currencyRepo.save(currency);
    }

    @Override
    public void deleteCurrencyByName(String currency_name) {
        if (!currencyExistsByName(currency_name)) {
            log.info("Currency {} doesn't exist.", currency_name);
            //поменять на нормальное исключение!!!!!!!!!!!
            throw new TestException();
        }
        currencyRepo.deleteByName(currency_name);
    }

    @Override
    public boolean currencyExistsByName(String currency_name) {
        return currencyRepo.existsByName(currency_name);
    }

    @Override
    public Set<Currency> getAllCurrencies() {
        Set<Currency> currencyList;
        try {
            currencyList = Objects.requireNonNull(currencyRepo.findAll());
        } catch (NullPointerException ex) {
            //поменять на нормальное исключение!!!!!!!!!!!
            throw new TestException();
        }
        return currencyList;
    }

    @Override
    public Currency getCurrencyByName(String currencyName) {
        Currency currency;
        try {
            currency = Objects.requireNonNull(currencyRepo.findByName(currencyName));
        } catch (NullPointerException ex) {
            throw new TestException();
        }
        return currency;
    }

}
