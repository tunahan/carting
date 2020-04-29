package com.trendyol.domain.coupon;

import com.trendyol.domain.cart.Cart;

import java.math.BigDecimal;

public interface CouponService {
    BigDecimal getDiscountAmount(Cart cart, Coupon coupon);

    boolean isCouponApplicable(Cart cart, Coupon coupon);
}
