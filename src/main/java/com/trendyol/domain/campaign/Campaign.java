package com.trendyol.domain.campaign;

import java.math.BigDecimal;

public class Campaign {

    public Campaign(long campaignId, long productId, long categoryId, int minProductNumber, BigDecimal campaignAmount, DiscountType campaignType) {
        this.campaignId = campaignId;
        this.productId = productId;
        this.categoryId = categoryId;
        this.minProductNumber = minProductNumber;
        this.campaignAmount = campaignAmount;
        this.campaignType = campaignType;
    }

    private long campaignId = 0;
    private long productId = 0;
    private long categoryId = 0;
    private int minProductNumber = 0;
    private BigDecimal campaignAmount;
    private DiscountType campaignType = DiscountType.FIXED;

    public long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(long campaignId) {
        this.campaignId = campaignId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public int getMinProductNumber() {
        return minProductNumber;
    }

    public void setMinProductNumber(int minProductNumber) {
        this.minProductNumber = minProductNumber;
    }

    public BigDecimal getCampaignAmount() {
        return campaignAmount;
    }

    public void setCampaignAmount(BigDecimal campaignAmount) {
        this.campaignAmount = campaignAmount;
    }

    public DiscountType getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(DiscountType campaignType) {
        this.campaignType = campaignType;
    }
}
