package com.trading.domain.shipment;

import com.trading.domain.cart.Cart;
import com.trading.domain.product.Product;
import com.trading.domain.util.ProductUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import static com.trading.domain.shipment.ShippingCons.fixedCost;

public class ShipmentCalculator implements ShipmentService {

    public BigDecimal calculateShipment(Cart cart, BigDecimal costPerDelivery) {

        BigDecimal shipmentPriceInTotal = BigDecimal.ZERO;

        shipmentPriceInTotal = shipmentPriceInTotal.add(getDeliveryBasedCost(cart.getProducts(), costPerDelivery)); //costPerDelivery * NumberOfDeliveries
        shipmentPriceInTotal = shipmentPriceInTotal.add(calculateProductBasedCost(cart)); //costPerProduct * NumberOfProducts
        shipmentPriceInTotal = shipmentPriceInTotal.add(fixedCost); //fixed
        return shipmentPriceInTotal;
    }

    private BigDecimal getDeliveryBasedCost(HashMap<Product, Integer> products, BigDecimal costPerDelivery) {
        BigDecimal amountForCategory;
        ArrayList<Product> distinctProductList = ProductUtil.getDistinctProductList(products);
        int numberOfDeliveries = distinctProductList.size();
        amountForCategory = costPerDelivery.multiply(BigDecimal.valueOf(numberOfDeliveries));
        return amountForCategory;
    }

    private static BigDecimal calculateProductBasedCost(Cart cart) {
        BigDecimal productBasedCost = ShippingCons.costPerProduct;
        return productBasedCost.divide(BigDecimal.valueOf(cart.getProducts().size()));
    }
}
