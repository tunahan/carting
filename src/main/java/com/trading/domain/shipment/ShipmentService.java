package com.trading.domain.shipment;

import com.trading.domain.cart.Cart;

import java.math.BigDecimal;

public interface ShipmentService {

    BigDecimal calculateShipment(Cart cart, BigDecimal costPerDelivery) ;
}
