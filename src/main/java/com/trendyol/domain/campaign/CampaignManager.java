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
        BigDecimal totalValue = BigDecimal.ZERO;
        int cartTotalProductNumber = cart.getTotalNumberOfProducts();
        for (Product product : cart.getProducts().keySet()) {
            int productCount = cart.getProducts().get(product);
            totalValue = totalValue.add(getDiscountPerProduct(product,productCount,cartTotalProductNumber));
        }
        return totalValue;
    }

    public BigDecimal getDiscountPerProduct(Product product, int productCount, int cartTotalProductNumber) {
        BigDecimal discountCost = BigDecimal.ZERO;
        List<Campaign> campaignList = campaignApplicableService.getAllApplicableCampaigns(product);
        List<Campaign> filteredByMinCartSize = campaignApplicableService.filterByCartsize(campaignList,cartTotalProductNumber);

        for (Campaign campaign : filteredByMinCartSize) {
            if (campaign.getCampaignType() == DiscountType.FIXED) {
                discountCost = discountCost.add(campaign.getCampaignAmount());
            } else if (campaign.getCampaignType() == DiscountType.RATE) {
                BigDecimal discountAmount = product.getPrice().multiply(campaign.getCampaignAmount());
                discountAmount = discountAmount.multiply(BigDecimal.valueOf(productCount));
                discountAmount = discountAmount.divide(BigDecimal.valueOf(100));
                discountCost = discountCost.add(discountAmount);
            }
        }
        return discountCost;
    }
}
