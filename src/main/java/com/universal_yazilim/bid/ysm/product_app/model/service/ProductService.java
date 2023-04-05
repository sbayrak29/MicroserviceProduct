package com.universal_yazilim.bid.ysm.product_app.model.service;

import com.universal_yazilim.bid.ysm.product_app.model.entity.Product;
import com.universal_yazilim.bid.ysm.product_app.utility.ExceptionMessageType;
import com.universal_yazilim.bid.ysm.product_app.utility.Util;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends AbstractProductService
{
    @Override
    protected List<Product> findByPriceGreaterThanEqual(Double price)
    {
        try
        {
            return productRepository.findByPriceGreaterThanEqual(price);
        }
        catch (Exception e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }

    @Override
    protected List<Product> findByPriceLessThan(Double price)
    {
        try
        {
            return productRepository.findByPriceLessThan(price);
        }
        catch (Exception e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }

    @Override
    public Product findByID(Integer id)
    {
        try {
            return productRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException(ExceptionMessageType.FIND_BY_ID.getValue()));
        }
        catch (RuntimeException e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }

    @Override
    public List<Product> getAll()
    {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product entity)
    {
        try
        {
            return productRepository.save(entity);
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
        catch (OptimisticLockingFailureException e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }

    @Override
    public void deleteByID(Integer id)
    {
        try
        {
            productRepository.deleteById(id);
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralExceptionInfo(e);
        }
    }
}
