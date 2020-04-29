package com.trading.test;

import com.trading.domain.cart.Cart;
import com.trading.domain.shipment.ShipmentCalculator;
import com.trading.domain.shipment.ShippingCons;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.trading.test.TestMaterial.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShipmentTest {

    @BeforeAll
    static void setup() {
        setCampaigns1Fixed1Rate();
        setAllCategories();
    }

    @Test
    void shipment_success() {
        Cart cart = getCartWith5ItemNew();
        ShipmentCalculator shipmentCalculator = new ShipmentCalculator();
        BigDecimal shipmentCost = shipmentCalculator.calculateShipment(cart, ShippingCons.costPerDelivery);
        assertEquals(shipmentCost,BigDecimal.valueOf(84.388),"shipment test failed");
    }
}
