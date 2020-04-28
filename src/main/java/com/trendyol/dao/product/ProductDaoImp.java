package com.trendyol.dao.product;

import com.trendyol.domain.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImp implements ProductDao {
    public List<Product> getAllProducts() {
        return new ArrayList<Product>() {
            {
                add(new Product(1,"IPad", BigDecimal.valueOf(900),5));
                add(new Product(1,"Samsung S10 Tablet", BigDecimal.valueOf(550),5));
                add(new Product(2,"Iphone 7S", BigDecimal.valueOf(800),6));
                add(new Product(3,"TV", BigDecimal.valueOf(750),7));
            }
        };
    }
}
