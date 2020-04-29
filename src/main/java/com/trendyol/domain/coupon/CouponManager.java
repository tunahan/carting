package com.trendyol.domain.coupon;

import com.trendyol.domain.util.DiscountType;
import com.trendyol.domain.cart.Cart;

import java.math.BigDecimal;

public class CouponManager implements CouponService {

    @Override
    public BigDecimal getDiscountAmount(Cart cart, Coupon coupon) {
        if (coupon.getCampaignType() == DiscountType.FIXED) {
            return coupon.getDiscountAmount();

        } else if (coupon.getCampaignType() == DiscountType.RATE) {
                return cart.getTotalAmountAfterCampaigns().multiply(coupon.getDiscountAmount()).divide(BigDecimal.valueOf(100));
        }
        return BigDecimal.ZERO;
    }

    @Override
    public boolean isCouponApplicable(Cart cart, Coupon coupon) {
        if (cart != null && coupon != null) {
            return cart.getTotalAmountAfterCampaigns().compareTo(coupon.getMinCartamountConstraint()) >= 1;
        }
        return false;
    }

}
