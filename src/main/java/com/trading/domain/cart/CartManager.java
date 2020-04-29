package com.trading.domain.cart;

import com.trading.domain.product.Product;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class CartManager {

    public static boolean isAddableToChart(Product product , int amount)
    {
        /*
        other rules here
         */
        return isProductValid(product);
    }

    public static boolean isProductValid(Product product)
    {
        return product.getId() != 0 &&
                StringUtils.isNotBlank(product.getTitle()) &&
                product.getPrice().compareTo(BigDecimal.ZERO) > -1;
    }
}
