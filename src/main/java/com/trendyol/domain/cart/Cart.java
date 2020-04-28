package com.trendyol.domain.cart;

import com.trendyol.domain.product.Product;

import java.util.HashMap;

public class Cart {

    HashMap<Product, Integer> products;
    public Cart() {
        products = new HashMap<>();
    }


    private static Cart instance = null;

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public void addProduct(Product product)
    {
        addProductWithQuantity(product,1);
    }

    public void addProductWithQuantity(Product product, int amount)
    {
        boolean isValid = CartManager.isProductValid(product) && amount<CartManager.MAX_ADDABLE_PRODUCT_NUMBER;
        if(isValid)
        {
            products.put(product,amount);
        }else
        {
            System.out.println("Products can not be added to Cart due to validation problem");
        }
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }
}
