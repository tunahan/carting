package com.trading.domain.coupon;

import com.trading.domain.util.DiscountType;

import java.math.BigDecimal;

public class Coupon {

    public Coupon(BigDecimal discountAmount, BigDecimal minCartamountConstraint, DiscountType campaignType) {
        this.discountAmount = discountAmount;
        this.minCartamountConstraint = minCartamountConstraint;
        this.campaignType = campaignType;
    }


    private BigDecimal discountAmount;
    private BigDecimal minCartamountConstraint;
    private DiscountType campaignType;

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getMinCartamountConstraint() {
        return minCartamountConstraint;
    }

    public void setMinCartamountConstraint(BigDecimal minCartamountConstraint) {
        this.minCartamountConstraint = minCartamountConstraint;
    }

    public DiscountType getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(DiscountType campaignType) {
        this.campaignType = campaignType;
    }
}
