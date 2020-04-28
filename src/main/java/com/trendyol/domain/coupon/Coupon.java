package com.trendyol.domain.coupon;

import java.math.BigDecimal;

public class Coupon {

    public Coupon(BigDecimal discountAmount, int minProductConstraint) {
        this.discountAmount = discountAmount;
        this.minProductConstraint = minProductConstraint;
    }

    public Coupon() {
    }

    private BigDecimal discountAmount;
    private int minProductConstraint;

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getMinProductConstraint() {
        return minProductConstraint;
    }

    public void setMinProductConstraint(int minProductConstraint) {
        this.minProductConstraint = minProductConstraint;
    }
}
