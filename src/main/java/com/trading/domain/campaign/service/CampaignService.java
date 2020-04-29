package com.trading.domain.campaign.service;

import com.trading.domain.cart.Cart;
import com.trading.domain.product.Product;

import java.math.BigDecimal;

public interface CampaignService {
    BigDecimal getTotalDiscount(Cart cart);

    BigDecimal getDiscountPerProduct(Product product, int productCount, int cartTotalProductNumber);
}
