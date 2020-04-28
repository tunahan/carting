package com.trendyol.test;

import com.trendyol.dao.campaign.CampaignDao;
import com.trendyol.dao.campaign.CampaignDaoImp;
import com.trendyol.dao.product.ProductDao;
import com.trendyol.dao.product.ProductDaoImp;
import com.trendyol.domain.campaign.Campaign;
import com.trendyol.domain.campaign.FixedPriceCampaign;
import com.trendyol.domain.cart.Cart;
import com.trendyol.domain.product.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleTest {

    //mocking
    static ProductDao productDao = ProductDaoImp.getInstance();
    static CampaignDao campaignDao = CampaignDaoImp.getInstance();

    @BeforeAll
    static void setup() {
        productDao.setProducsTable(new ArrayList<Product>() {
            {
                add(new Product(1,"IPad", BigDecimal.valueOf(900),5));
                add(new Product(2,"Samsung S10 Tablet", BigDecimal.valueOf(550),5));
                add(new Product(3,"Iphone 7S", BigDecimal.valueOf(800),6));
                add(new Product(4,"TV", BigDecimal.valueOf(750),7));
            }
        });
        campaignDao.setCampaignTable(new ArrayList<Campaign>() {
            {
                add(new FixedPriceCampaign(1,0,1, 2,BigDecimal.valueOf(30)));
                add(new FixedPriceCampaign(1,0,1, 2,BigDecimal.valueOf(30)));
            }
        });
//        Cart cart = new Cart();

    }



    @BeforeEach
    void init() {
        System.out.println("Before-Each");
    }


    @Test
    void firstTest()
    {
        assertTrue(1==1);
    }
    @Test
    void creatingProductTest()
    {
        Product product = new Product();
    }

    @Test
    void noDiscountTest()
    {

    }

    @Test
    void onlyCampaignTest()
    {

    }

    @Test
    void onlyCouponTest()
    {

    }


}
