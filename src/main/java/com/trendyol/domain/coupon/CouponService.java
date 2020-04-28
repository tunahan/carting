package com.trendyol.domain.coupon;

import com.trendyol.domain.cart.Cart;

import java.math.BigDecimal;

public abstract class CouponService {
    public abstract BigDecimal getDiscountAmount(Cart cart, Coupon coupon);

    public boolean isCouponApplicable(Cart cart, Coupon coupon)
    {
        if(cart != null && coupon != null)
        {
            return cart.getTotalNumberOfProducts() >= coupon.getMinProductConstraint();
        }
        return false;
    }
}
