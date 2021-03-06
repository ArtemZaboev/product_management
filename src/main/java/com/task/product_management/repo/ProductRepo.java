package com.task.product_management.repo;

import com.task.product_management.model.Currency;
import com.task.product_management.model.Language;
import com.task.product_management.model.NameAndDescription;
import com.task.product_management.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends PagingAndSortingRepository<Product,Long> {

    Page<Product> findAll();
    List<Product> getAll();
    Product getProductById(long id);
    Product save(Product product);
    void deleteById(Long id);
}
