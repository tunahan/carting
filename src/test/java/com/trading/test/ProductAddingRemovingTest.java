package com.trading.test;

import com.trading.domain.cart.Cart;
import com.trading.domain.product.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.trading.test.TestMaterial.*;
import static com.trading.test.TestMaterial.getCartWith5ItemNew;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductAddingRemovingTest {

    @BeforeAll
    static void setup() {
        setCampaigns1Fixed1Rate();
        setAllCategories();
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
        int countBeforeDeletion = cart.getTotalNumberOfProducts();
        int amountToBeRemoved = 2;
        cart.removeProduct(4,amountToBeRemoved);
        int countAfterDeletion = cart.getTotalNumberOfProducts();
        assertEquals(countBeforeDeletion - countAfterDeletion , amountToBeRemoved);
    }
}
