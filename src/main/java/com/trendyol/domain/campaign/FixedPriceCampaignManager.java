package com.trendyol.domain.campaign;

import com.trendyol.domain.cart.Cart;
import com.trendyol.domain.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FixedPriceCampaignManager extends CampaignService {

    public List<Campaign> getAllFixedCampaignes() {
        return getallCampaignes().stream().filter(campaign -> campaign instanceof FixedPriceCampaign).collect(Collectors.toList());
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
                    FixedPriceCampaign fixedPriceCampaign = (FixedPriceCampaign) campaign;
                    totalValue = totalValue.add(fixedPriceCampaign.getDiscountFixed());
                }
            }
        }
        return totalValue;
    }


    @Override
    public List<Campaign> getAllApplicableCampaigns(Product product,int cartSize) {
        List<Campaign> allFixedCampaignes = getAllFixedCampaignes();
        List<Campaign> allApplicableCampaignes = new ArrayList<>();
        for (Campaign campaign : allFixedCampaignes)
        {
            if(isApplicable(product,campaign,cartSize) && campaign instanceof FixedPriceCampaign)
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
