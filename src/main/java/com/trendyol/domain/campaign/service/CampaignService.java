package com.trendyol.domain.campaign.service;

import com.trendyol.domain.cart.Cart;
import com.trendyol.domain.product.Product;

import java.math.BigDecimal;

public interface CampaignService {
    BigDecimal getTotalDiscount(Cart cart);

    BigDecimal getDiscountPerProduct(Product product, int productCount, int cartTotalProductNumber);
}
