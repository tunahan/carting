package com.trendyol.test;

import com.trendyol.dao.campaign.CampaignDao;
import com.trendyol.dao.campaign.CampaignDaoImp;
import com.trendyol.dao.category.CategoryDao;
import com.trendyol.dao.category.CategoryDaoImp;
import com.trendyol.domain.cart.Cart;
import com.trendyol.domain.product.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.trendyol.test.TestMaterial.*;
import static com.trendyol.test.TestMaterial.getCartWith5ItemNew;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductAddingRemovingTest {

    @BeforeAll
    static void setup() {
        CampaignDao campaignDao = CampaignDaoImp.getInstance();
        setCampaigns1Fixed1Rate(campaignDao);
        CategoryDao categoryDao = CategoryDaoImp.getInstance();
        setAllCategories(categoryDao);
    }



    @BeforeEach
    void init() {
    }

    @Test
    void domain_addingProductTest_success()
    {
        Cart cart = getCartWith5ItemNew();
        cart.addProduct(new Product(1, "IPad", BigDecimal.valueOf(900), 5));
        long numberOfItemMoreThanOnce = cart.getProducts().keySet().stream().filter(product -> cart.getProducts().get(product)> 1).count();
        assertEquals(numberOfItemMoreThanOnce , 2);
    }

    @Test
    void domain_removingProductTest_success()
    {
        Cart cart = getCartWith5ItemNew();
        cart.addProduct(new Product(99, "IdeaPad", BigDecimal.valueOf(900), 5),2);
        cart.addProduct(new Product(99, "IdeaPad", BigDecimal.valueOf(900), 5));
        int countBeforeDeletion = cart.getTotalNumberOfProducts();
        int amountToBeRemoved = 2;
        cart.removeProduct(99,amountToBeRemoved);
        int countAfterDeletion = cart.getTotalNumberOfProducts();
        assertEquals(countBeforeDeletion - countAfterDeletion , amountToBeRemoved);
    }
}
