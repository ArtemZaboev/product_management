package com.task.product_management.repo;


import com.task.product_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

//    Page<Product> findAll();
    List<Product> findAll();
    Product getProductById(long id);
    Product save(Product product);
    void deleteById(Long id);
}
