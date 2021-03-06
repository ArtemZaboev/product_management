package com.task.product_management.services;

import com.task.product_management.model.Language;
import com.task.product_management.model.NameAndDescription;

import java.util.Set;

public interface NameAndDescriptionService {
    NameAndDescription addNameAndDescription(NameAndDescription nameAndDescription);
    void deleteNameAndDescription(NameAndDescription nameAndDescription);
    NameAndDescription updateNameAndDescription(NameAndDescription nameAndDescription);
    Set<NameAndDescription> getNameAndDescriptionByProductId(long product_id);
}
