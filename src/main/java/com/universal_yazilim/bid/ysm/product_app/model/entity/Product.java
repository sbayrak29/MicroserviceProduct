package com.universal_yazilim.bid.ysm.product_app.model.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@SequenceGenerator(name = "PRODUCTS_SEQUENCE", sequenceName = "PRODUCTS_SEQ", initialValue = 1, allocationSize = 1)
@Table(name = "PRODUCTS")
@Entity
public class Product
{
    @Column(name = "PRODUCT_ID",  nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTS_SEQUENCE")
    @Id
    private Integer productID;

    @Column(length = 120, nullable = false)
    private String name;

    @Column(length = 80, nullable = false)
    private String category;

    private String description;

    private Double price;

    @Column(nullable = false)
    private Date created;
}
