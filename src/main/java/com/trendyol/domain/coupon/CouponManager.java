package com.trendyol.domain.coupon;

import com.trendyol.domain.campaign.Campaign;
import com.trendyol.domain.campaign.FixedPriceCampaign;
import com.trendyol.domain.cart.Cart;
import com.trendyol.domain.product.Product;

import java.math.BigDecimal;

public class CouponManager extends CouponService {

    @Override
    public BigDecimal getDiscountAmount(Cart cart, Coupon coupon) {
        return coupon.getDiscountAmount();
    }
}
