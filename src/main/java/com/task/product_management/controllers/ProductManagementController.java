package com.task.product_management.controllers;

import com.task.product_management.model.Product;
import com.task.product_management.services.ProductManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/management")
public class ProductManagementController {
    private final ProductManagementService productManagementService;

    @Autowired
    public ProductManagementController(ProductManagementService productManagementService) {
        this.productManagementService = productManagementService;
    }
    @GetMapping("{id}")
    public Product getProductById(@PathVariable("id") long id)  {
        return productManagementService.getProductById(id);
    }
    @GetMapping
    public List<Product> getProducts()  {
        return productManagementService.getProducts();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable("id") long id) {
        productManagementService.deleteProduct(id);

    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return productManagementService.saveProduct(product);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@RequestBody Product product) {
        productManagementService.updateProduct(product);
    }
}
