package com.trading.domain.coupon;

import com.trading.domain.cart.Cart;

import java.math.BigDecimal;

public interface CouponService {
    BigDecimal getDiscountAmount(Cart cart, Coupon coupon);

    boolean isCouponApplicable(Cart cart, Coupon coupon);
}
