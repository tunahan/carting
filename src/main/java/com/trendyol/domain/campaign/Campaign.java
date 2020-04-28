package com.trendyol.domain.campaign;

import com.trendyol.domain.product.Product;

import java.math.BigDecimal;

public abstract class Campaign {
    public Campaign(long campaignId, long productId, long categoryId, int minProductNumber) {
        this.campaignId = campaignId;
        this.productId = productId;
        this.categoryId = categoryId;
        this.minProductNumber = minProductNumber;
    }

    private long campaignId = 0;
    private long productId = 0;
    private long categoryId = 0;
    private int minProductNumber = 0;

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

    public long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(long campaignId) {
        this.campaignId = campaignId;
    }

    public int getMinProductNumber() {
        return minProductNumber;
    }

    public void setMinProductNumber(int minProductNumber) {
        this.minProductNumber = minProductNumber;
    }
}
