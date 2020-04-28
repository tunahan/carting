package com.trendyol.domain.util;

import com.trendyol.dao.campaign.CampaignDao;
import com.trendyol.dao.campaign.CampaignDaoImp;
import com.trendyol.domain.campaign.Campaign;
import com.trendyol.domain.cart.Cart;
import com.trendyol.domain.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class ShipmentCalculator {

    public static BigDecimal costPerDelivery = BigDecimal.TEN;
    public static BigDecimal fixedAmount = BigDecimal.valueOf(2.99);

    public static BigDecimal calculateShipment(Cart cart) {

        BigDecimal shipmentPriceInTotal = BigDecimal.ZERO;
        BigDecimal amountOfProducts = BigDecimal.ZERO;
        BigDecimal amountForCategory = BigDecimal.ZERO;

        CampaignDao campaignDao = new CampaignDaoImp();
        HashMap<Product, Integer> products = cart.getProducts();
        ArrayList<Campaign> campaignArrayList = new ArrayList<>();
        products.keySet().stream().filter(distinctByKey(Product::getCategoryId)).forEach(product -> {
            campaignArrayList.add(campaignDao.getCampaignByCampaignId(product.getId()));
        });
        int numberOfDeliveries = campaignArrayList.size();
        amountForCategory = costPerDelivery.multiply(BigDecimal.valueOf(numberOfDeliveries));


        for (Product product : products.keySet()) {
            int numberOfProduct = products.size(); //products.get(product);
            //NumberOfProducts is the number of different products in the cart. It is not the quantity of products ??
            amountOfProducts = amountOfProducts.add(product.getPrice().multiply(BigDecimal.valueOf(numberOfProduct)));
        }

        shipmentPriceInTotal = shipmentPriceInTotal.add(amountForCategory);
        shipmentPriceInTotal = shipmentPriceInTotal.add(amountOfProducts);
        shipmentPriceInTotal = shipmentPriceInTotal.add(fixedAmount);

        return shipmentPriceInTotal;
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
