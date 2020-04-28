package com.trendyol.dao.product;

import com.trendyol.domain.product.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProducts();
}
