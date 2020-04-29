package com.trendyol.domain.shipment;

import com.trendyol.domain.cart.Cart;

import java.math.BigDecimal;

public interface ShipmentService {

    BigDecimal calculateShipment(Cart cart, BigDecimal costPerDelivery) ;
}
