package com.trendyol.test;

import com.trendyol.dao.product.ProductDao;
import com.trendyol.dao.product.ProductDaoImp;
import com.trendyol.domain.campaign.FixedPriceCampaignManager;
import com.trendyol.domain.cart.Cart;
import com.trendyol.domain.campaign.PercentagePriceCampaignManager;
import com.trendyol.domain.product.Product;
import com.trendyol.domain.product.ProductManager;
import com.trendyol.domain.product.ProductService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {

        BigDecimal tot1 = BigDecimal.valueOf(10);
        BigDecimal tot2 = BigDecimal.valueOf(5);
        System.out.println(tot1);
        Integer a = new Integer(5);
        Integer b = new Integer(10);
        HashMap<Integer,Integer> map  = new HashMap<>();
        map.put(a,6);
        Integer ab = map.get(b);
        System.out.println(ab);
//        ProductService productService = new ProductManager(new ProductDaoImp());
//        List<Product> productList =productService.getAllProductsDiscounted(new FixedPriceCampaignManager());
//        productList.stream().forEach(product -> System.out.println(product.getPrice()));
//
//        Cart cart = Cart.getInstance();
//        Product s10Tablet = new Product(1,"Samsung S10 Tablet", BigDecimal.valueOf(550),5);
//        cart.addProduct(s10Tablet);
    }
}
