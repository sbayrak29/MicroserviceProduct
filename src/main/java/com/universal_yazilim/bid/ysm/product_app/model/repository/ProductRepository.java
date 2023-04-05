package com.universal_yazilim.bid.ysm.product_app.model.repository;

import com.universal_yazilim.bid.ysm.product_app.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    List<Product> findByPriceGreaterThanEqual(Double price);

    List<Product> findByPriceLessThan(Double price);
}
