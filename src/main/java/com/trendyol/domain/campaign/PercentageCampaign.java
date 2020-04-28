package com.trendyol.domain.campaign;

public class PercentageCampaign extends Campaign {


    public PercentageCampaign(long campaignId, long productId, long categoryId, int minProductNumber, int discountPercentage) {
        super(campaignId, productId, categoryId, minProductNumber);
        this.discountPercentage = discountPercentage;
    }

    int discountPercentage = 0;

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

}
