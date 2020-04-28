package com.trendyol.test;

import com.trendyol.dao.product.ProductDaoImp;
import com.trendyol.domain.campaign.FixedPriceCampaignManager;
import com.trendyol.domain.cart.Cart;
import com.trendyol.domain.campaign.PercentagePriceCampaignManager;
import com.trendyol.domain.product.Product;
import com.trendyol.domain.product.ProductManager;
import com.trendyol.domain.product.ProductService;

import java.math.BigDecimal;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {

        ProductService productService = new ProductManager(new ProductDaoImp());
        List<Product> productList =productService.getAllProductsDiscounted(new FixedPriceCampaignManager());
        productList.stream().forEach(product -> System.out.println(product.getPrice()));

        Cart cart = Cart.getInstance();
        Product s10Tablet = new Product(1,"Samsung S10 Tablet", BigDecimal.valueOf(550),5);
        cart.addProduct(s10Tablet);
    }
}
