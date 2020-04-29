package com.trendyol.domain.campaign;

import com.trendyol.domain.cart.Cart;
import com.trendyol.domain.product.Product;

import java.math.BigDecimal;
import java.util.List;

public class CampaignManager {

    public static int MAX_APPLICABLE_CAMPAIGN_COUNT = 3;

    CampaignApplicableService campaignApplicableService;

    public CampaignManager(CampaignApplicableService campaignApplicableService) {
        this.campaignApplicableService = campaignApplicableService;
    }

    public BigDecimal getTotalDiscount(Cart cart) {
        int appliedCampaignCounter = 0;
        BigDecimal totalValue = BigDecimal.ZERO;
        for (Product product : cart.getProducts().keySet()) {
            Integer productCount = cart.getProducts().get(product);
            List<Campaign> campaignList = campaignApplicableService.getAllApplicableCampaigns(product);
            List<Campaign> filteredByMinCartSize = campaignApplicableService.filterByCartsize(campaignList,cart.getTotalNumberOfProducts());

            for (Campaign campaign : filteredByMinCartSize) {
                if (campaign.getCampaignType() == DiscountType.FIXED) {
                    totalValue = totalValue.add(campaign.getCampaignAmount());
                    appliedCampaignCounter++;
                } else if (campaign.getCampaignType() == DiscountType.RATE) {
                    BigDecimal discountAmount = product.getPrice().multiply(campaign.getCampaignAmount());
                    discountAmount = discountAmount.multiply(BigDecimal.valueOf(productCount));
                    discountAmount = discountAmount.divide(BigDecimal.valueOf(100));
                    totalValue = totalValue.add(discountAmount);
                    appliedCampaignCounter++;
                }
            }
        }
        return totalValue;
    }
}
