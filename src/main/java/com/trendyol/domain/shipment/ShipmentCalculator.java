package com.trendyol.domain.shipment;

import com.trendyol.domain.cart.Cart;
import com.trendyol.domain.product.Product;
import com.trendyol.domain.util.ProductUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import static com.trendyol.domain.shipment.ShippingCons.fixedCost;

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

    /*
     * TODO
     * CostPerProduct is not explained
     */
    private static BigDecimal calculateProductBasedCost(Cart cart) {
        for (Product product : cart.getProducts().keySet()) {
            int numberOfProduct = cart.getProducts().get(product);
            return product.getPrice().multiply(BigDecimal.valueOf(numberOfProduct));
        }
        return BigDecimal.ZERO;
    }
}
