package com.task.product_management.services;

import com.task.product_management.exception.TestException;
import com.task.product_management.model.Language;
import com.task.product_management.model.NameAndDescription;
import com.task.product_management.model.Price;
import com.task.product_management.model.Product;
import com.task.product_management.repo.NameAndDescriptionRepo;
import com.task.product_management.repo.PriceRepo;
import com.task.product_management.repo.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@Slf4j
public class ProductManagementServiceImpl implements ProductManagementService {

    private final ProductRepo productRepo;
    private final NameAndDescriptionRepo nameAndDescriptionRepo;
    private final PriceRepo priceRepo;
    private final CurrencyService currencyService;
    private final LanguageService languageService;

    @Autowired
    public ProductManagementServiceImpl(ProductRepo productRepo,
                                        NameAndDescriptionRepo nameAndDescriptionRepo,
                                        PriceRepo priceRepo,
                                        CurrencyService currencyService,
                                        LanguageService languageService) {
        this.productRepo = productRepo;
        this.nameAndDescriptionRepo = nameAndDescriptionRepo;
        this.priceRepo = priceRepo;
        this.currencyService = currencyService;
        this.languageService = languageService;
    }


    @Override
    public void saveProduct(Product product) {
        if (product.getName_description().isEmpty()) {
            log.info("There are no names for product");
            //изменить исключение!!!!!!!
            throw new TestException();
        } else if (product.getPrices().isEmpty()) {
            log.info("There are no prices for product");
            //изменить исключение!!!!!!!
            throw new TestException();
        } else if (!(checkPrices(product.getPrices()) || checkNameAndDescriptions(product.getName_description()))) {
            //изменить исключение!!!!!!!
            throw new TestException();
        }
        Instant date = Instant.now();
        product.setCreateDate(date);
        product.setUpdateDate(date);
        productRepo.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        productRepo.deleteById(id);
    }

    @Override
    public void updateProduct(Product product) {
        Product dbProduct = productRepo.findById(product.getId()).orElse(null);

    }

    @Override
    public List<Product> getProducts() {
        List<Product> products;
        try {
            //мб Pages нужно сделать
            products = Objects.requireNonNull(productRepo.getAll());
        } catch (NullPointerException e) {
            throw new TestException();
        }
        return products;
    }

    @Override
    public Product getProductById(long id) {
        Product product;
        try{
            //хз
            product=Objects.requireNonNull(productRepo.getProductById(id));
        }catch (NullPointerException e){
            throw new TestException();
        }
        return product;
    }

    public boolean checkPrices(Set<Price> prices) {
        for (Price price : prices) {
            String currencyName = price.getCurrency().getName();
            if (!currencyService.currencyExistsByName(currencyName)) {
                log.info("Currency {} doesn't exist", currencyName);
                return false;
            } else if (price.getValue().equals(BigDecimal.ZERO)) {
                log.info("Price value can't be equal zero.");
                return false;
            }
        }
        return true;
    }

    public boolean checkNameAndDescriptions(Set<NameAndDescription> nameAndDescriptionSet) {
        for (NameAndDescription nameAndDescription : nameAndDescriptionSet) {
            String languageName = nameAndDescription.getLanguage().getName();
            if (!languageService.languageExistsByName(languageName)) {
                log.info("Language {} doesn't exist", languageName);
                return false;
            } else if (nameAndDescription.getName().isEmpty()) {
                log.info("Product name can't be empty");
            }
        }
        return true;
    }
}
