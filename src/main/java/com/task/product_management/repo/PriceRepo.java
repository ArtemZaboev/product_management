package com.task.product_management.repo;

import com.task.product_management.model.Price;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PriceRepo extends PagingAndSortingRepository<Price,Long> {
}
