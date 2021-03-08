package com.task.product_management.services;

import com.task.product_management.exception.TestException;
import com.task.product_management.model.*;
import com.task.product_management.repo.NameAndDescriptionRepo;
import com.task.product_management.repo.PriceRepo;
import com.task.product_management.repo.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ProductManagementServiceImpl implements ProductManagementService {

    private final ProductRepo productRepo;
    private final CurrencyService currencyService;
    private final LanguageService languageService;

    @Autowired
    public ProductManagementServiceImpl(ProductRepo productRepo,
                                        CurrencyService currencyService,
                                        LanguageService languageService) {
        this.productRepo = productRepo;
        this.currencyService = currencyService;
        this.languageService = languageService;
    }

    @Override
    public Product saveProduct(Product product) {
        if (product.getName_description().isEmpty()) {
            log.info("There are no names for product");
            //изменить исключение!!!!!!!
            throw new TestException();
        } else if (product.getPrices().isEmpty()) {
            log.info("There are no prices for product");
            //изменить исключение!!!!!!!
            throw new TestException();
        } else if (!checkProduct(product)) {
            throw new TestException();
        }
        Instant createDate = Instant.now();
        product.setCreateDate(createDate);
        product.setUpdateDate(createDate);
        Product dbProduct = productRepo.save(product);
        if (dbProduct == null) {
            throw new TestException();
        }
        return dbProduct;
    }

    @Override
    public void deleteProduct(long id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        Product dbProduct = productRepo.findById(product.getId()).orElse(null);
        if (dbProduct != null) {

            boolean dataCorrect = checkProduct(product);
            if (dataCorrect) {
                checkChanges(product, dbProduct);
            } else {
                throw new TestException();
            }
            dbProduct.setUpdateDate(Instant.now());
            dbProduct = productRepo.save(dbProduct);
            log.info("Product {} successfully updated", dbProduct.getId());
            return dbProduct;
        } else throw new TestException();
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products;
        try {
            //мб Pages нужно сделать
            products = Objects.requireNonNull(productRepo.findAll());
        } catch (NullPointerException e) {
            throw new TestException();
        }
        return products;
    }


    @Override
    public Product getProductById(long id) {
        Product product;
        try {
            //хз
            product = Objects.requireNonNull(productRepo.getProductById(id));
        } catch (NullPointerException e) {
            log.info("Product with id= {} not found.", id);
            throw new TestException();
        }
        return product;
    }

    private boolean checkProduct(Product product) {
        return checkPrices(product) && checkNameAndDescriptions(product);

    }


    private boolean checkPrices(Product product) {
        for (Price price : product.getPrices()) {
            String currencyName = price.getCurrency().getName();
            Currency currency = currencyService.getCurrencyByName(currencyName);
            if (currency == null) {
                log.info("Currency {} doesn't exist", currencyName);
                return false;
            } else if (price.getValue().equals(BigDecimal.ZERO)) {
                log.info("Price value can't be equal zero.");
                return false;
            }
            price.setCurrency(currency);
        }
        return true;
    }

    private boolean checkNameAndDescriptions(Product product) {
        for (NameAndDescription info : product.getName_description()) {
            String languageName = info.getLanguage().getName();
            Language language = languageService.getLanguageByName(languageName);
            if (language == null) {
                log.info("Language {} doesn't exist", languageName);
                return false;
            } else if (info.getName().isEmpty()) {
                log.info("Product name can't be empty");
            }
            info.setLanguage(language);
        }
        return true;
    }

    private void checkChanges(Product product, Product dbProduct) {
        List<Price> dbPrices = dbProduct.getPrices();
        List<Price> prices = product.getPrices();
        List<NameAndDescription> dbNameAndDescription = dbProduct.getName_description();
        List<NameAndDescription> nameAndDescriptions = product.getName_description();

        for (NameAndDescription n : nameAndDescriptions) {
            if (!dbNameAndDescription.contains(n)) {
                dbProduct.getName_description().add(n);
            }
        }
        for (Price p : prices) {
            if (!dbPrices.contains(p)) {
                dbProduct.getPrices().add(p);
            }
        }

    }
}