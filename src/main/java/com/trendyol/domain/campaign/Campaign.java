package com.trendyol.domain.campaign;

import com.trendyol.domain.product.Product;

import java.math.BigDecimal;

public abstract class Campaign {
    public Campaign(long productId, long categoryId, long campaignId) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.campaignId = campaignId;
    }



    long productId = 0;
    long categoryId = 0;
    long campaignId = 0;

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
}
