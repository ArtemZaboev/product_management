package com.task.product_management.services;

import com.task.product_management.model.Price;

import java.math.BigDecimal;

public interface PriceService {
    Price addPrice(Price price);
    void deletePriceById(long price_id);
    Price updatePrice(Price price);
    Price getPrice(long priceId);
}
