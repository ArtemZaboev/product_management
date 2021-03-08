package com.task.product_management.services;

import com.task.product_management.model.Currency;
import com.task.product_management.model.Language;
import com.task.product_management.model.NameAndDescription;
import com.task.product_management.model.Product;

import java.util.List;

public interface ProductClientService {
    List<Product> findByNameAndDescription(String product_name,
                                           String product_Description,
                                           Currency currency,
                                           Language language);
    Product getProductById(Long product_id,
                           Currency currency,
                           Language language);

}
