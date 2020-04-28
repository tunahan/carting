package com.trendyol.domain.campaign;

import com.trendyol.domain.cart.Cart;
import com.trendyol.domain.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PercentagePriceCampaignManager extends CampaignService  {

    public List<Campaign> getAllPercentageCampaignes() {
        return getallCampaignes().stream().filter(campaign -> campaign instanceof PercentageCampaign).collect(Collectors.toList());
    }


    @Override
    public BigDecimal getTotalDiscount(Cart cart) {
        BigDecimal totalValue = BigDecimal.ZERO;
        for(Product product : cart.getProducts().keySet())
        {
            List<Campaign> campaignList = getAllApplicableCampaigns(product,cart.getTotalNumberOfProducts());
            for(Campaign campaign :campaignList)
            {
                if(campaign != null)
                {
                    PercentageCampaign percentageCampaign = (PercentageCampaign) campaign;
                    BigDecimal dscountAmount = product.getPrice().multiply(BigDecimal.valueOf(percentageCampaign.discountPercentage));
                    totalValue = totalValue.add(dscountAmount);
                }
            }
        }
        return totalValue;
    }

    @Override
    public List<Campaign> getAllApplicableCampaigns(Product product, int cartSize) {
        List<Campaign> allPercentageCampaignes = getAllPercentageCampaignes();
        List<Campaign> allApplicableCampaignes = new ArrayList<>();
        for (Campaign campaign : allPercentageCampaignes)
        {
            if(isApplicable(product,campaign,cartSize) && campaign instanceof PercentageCampaign)
            {
                allApplicableCampaignes.add(campaign);
            }
        }
        return allApplicableCampaignes;
    }

    @Override
    public List<Campaign> getAllApplicableCampaigns(Cart cart) {
        return null;
    }
}
