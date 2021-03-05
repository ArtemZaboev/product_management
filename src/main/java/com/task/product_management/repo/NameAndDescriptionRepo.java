package com.task.product_management.repo;

import com.task.product_management.model.NameAndDescription;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NameAndDescriptionRepo extends PagingAndSortingRepository<NameAndDescription,Long> {
}
