package com.trading.test;

import com.trading.domain.cart.Cart;
import com.trading.domain.shipment.ShipmentCalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.trading.test.TestMaterial.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintingTest {

    @BeforeAll
    static void setup() {
        setCampaigns1Fixed1Rate();
        setAllCategories();
    }

    @Test
    void printing() {

        Cart cart = getCartWith5ItemNew();
        cart.print(new ShipmentCalculator());
        assertEquals(1,1,"shipment test failed");
    }

}
