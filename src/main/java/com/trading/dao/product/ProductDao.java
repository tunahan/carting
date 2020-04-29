package com.trading.dao.product;

import com.trading.domain.product.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductDao {
    List<Product> getAllProducts();
    void setProducsTable(ArrayList<Product> producsTable);
}
