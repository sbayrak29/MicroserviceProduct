package com.universal_yazilim.bid.ysm.product_app.model.service;

import com.universal_yazilim.bid.ysm.product_app.model.entity.Product;
import com.universal_yazilim.bid.ysm.product_app.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractProductService implements EntityService<Product, Integer>
{
    @Autowired
    protected ProductRepository productRepository;

    protected abstract List<Product> findByPriceGreaterThanEqual(Double price);

    protected abstract List<Product> findByPriceLessThan(Double price);
}
