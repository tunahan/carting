package com.trendyol.domain.cart;

import com.trendyol.domain.product.Product;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class CartManager {

    public static int MAX_ADDABLE_PRODUCT_NUMBER = 999;

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
