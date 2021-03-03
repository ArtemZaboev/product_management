package com.task.product_management.services;

import com.task.product_management.model.Product;

import java.util.List;

public interface ProductManagementService {
    void saveProduct(Product product);
    void deleteProduct(long id);
    void updateProduct(Product product);
    List<Product> getProducts();
    Product getProductById(long id);

}
