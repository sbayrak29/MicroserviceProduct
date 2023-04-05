package com.universal_yazilim.bid.ysm.product_app.controller;

import com.universal_yazilim.bid.ysm.product_app.model.entity.Product;
import com.universal_yazilim.bid.ysm.product_app.model.service.AbstractProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("api/product")
@RestController
public class ProductController
{
    @Autowired
    private AbstractProductService productService;

    @DeleteMapping("{id}")
    public ResponseEntity deleteByID (@PathVariable(name="id") Integer productID)
    {
        productService.deleteByID(productID);
        return ResponseEntity.ok("productID" + productID + " has been deleted .");
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product)
    {
        product.setCreated(new Date());

        Product savedProduct = productService.save(product);

        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll()
    {
        List<Product> productList = productService.getAll();

        return ResponseEntity.ok(productList);
    }
}
