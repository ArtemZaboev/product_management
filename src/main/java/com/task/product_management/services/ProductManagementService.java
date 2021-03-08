package com.task.product_management.services;

import com.task.product_management.model.Product;

import java.util.List;

public interface ProductManagementService {
    Product saveProduct(Product product);
    void deleteProduct(long id);
    Product updateProduct(Product product);
    List<Product> getProducts();
    Product getProductById(long id);

}
