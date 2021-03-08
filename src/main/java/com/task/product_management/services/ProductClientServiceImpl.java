package com.task.product_management.services;

import com.task.product_management.model.Currency;
import com.task.product_management.model.Language;
import com.task.product_management.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class ProductClientServiceImpl implements ProductClientService {
    @Override
    public List<Product> findByNameAndDescription(String product_name, String product_Description, Currency currency, Language language) {
        return null;
    }

    @Override
    public Product getProductById(Long product_id, Currency currency, Language language) {
        return null;
    }
}
