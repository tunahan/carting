package com.trendyol.test;

import com.trendyol.dao.campaign.CampaignDao;
import com.trendyol.dao.campaign.CampaignDaoImp;
import com.trendyol.dao.category.CategoryDao;
import com.trendyol.dao.category.CategoryDaoImp;
import com.trendyol.domain.cart.Cart;
import com.trendyol.domain.shipment.ShipmentCalculator;
import com.trendyol.domain.shipment.ShippingCons;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.trendyol.test.TestMaterial.*;
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
