package com.task.product_management.services;

import com.task.product_management.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductManagementServiceImpl implements ProductManagementService{

    @Override
    public void saveProduct(Product product) {

    }

    @Override
    public void deleteProduct(long id) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product getProductById(long id) {
        return null;
    }
}
