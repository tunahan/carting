package com.trendyol.domain.campaign;

public class PercentageCampaign extends Campaign {

    public PercentageCampaign(int productId, Integer categoryId, int discountPercentage) {
        super(productId, categoryId);
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
