package com.trading.domain.campaign.concrete;

import com.trading.domain.util.DiscountType;
import com.trading.domain.campaign.service.CampaignApplicableService;
import com.trading.domain.campaign.service.CampaignService;
import com.trading.domain.cart.Cart;
import com.trading.domain.product.Product;

import java.math.BigDecimal;
import java.util.List;

public class CampaignManager implements CampaignService {

    public static final int MAX_APPLICABLE_CAMPAIGN_COUNT = 3;

    private final CampaignApplicableService campaignApplicableService;

    public CampaignManager(CampaignApplicableService campaignApplicableService) {
        this.campaignApplicableService = campaignApplicableService;
    }

    @Override
    public BigDecimal getTotalDiscount(Cart cart) {
        BigDecimal totalValue = BigDecimal.ZERO;
        int cartTotalProductNumber = cart.getTotalNumberOfProducts();
        for (Product product : cart.getProducts().keySet()) {
            int productCount = cart.getProducts().get(product);
            totalValue = totalValue.add(getDiscountPerProduct(product,productCount,cartTotalProductNumber));
        }
        return totalValue;
    }

    @Override
    public BigDecimal getDiscountPerProduct(Product product, int productCount, int cartTotalProductNumber) {
        BigDecimal discountCostTotal = BigDecimal.ZERO;
        List<Campaign> campaignList = campaignApplicableService.getAllApplicableCampaigns(product);
        List<Campaign> filteredByMinCartSize = campaignApplicableService.filterByCartsize(campaignList,cartTotalProductNumber);
        for (Campaign campaign : filteredByMinCartSize) {
            if (campaign.getCampaignType() == DiscountType.FIXED) {
                discountCostTotal = discountCostTotal.add(campaign.getCampaignAmount());
            } else if (campaign.getCampaignType() == DiscountType.RATE) {
                BigDecimal discountAmountRate = getRateDiscountPerProduct(product, productCount, campaign);
                discountCostTotal = discountCostTotal.add(discountAmountRate);
            }
        }
        return discountCostTotal;
    }

    private BigDecimal getRateDiscountPerProduct(Product product, int productCount, Campaign campaign) {
        BigDecimal discountAmount = product.getPrice().multiply(campaign.getCampaignAmount());
        discountAmount = discountAmount.multiply(BigDecimal.valueOf(productCount));
        discountAmount = discountAmount.divide(BigDecimal.valueOf(100));
        return discountAmount;
    }
}
