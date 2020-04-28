package com.trendyol.domain.campaign;

import com.trendyol.domain.cart.Cart;
import com.trendyol.domain.product.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class FixedPriceCampaignManager extends CampaignService {

    public List<Campaign> getAllFixedCampaignes() {
        return getallCampaignes().stream().filter(campaign -> campaign instanceof FixedPriceCampaign).collect(Collectors.toList());
    }



    @Override
    public Cart updateChartWithCampaign(Cart cart) {
        for(Product product : cart.getProducts().keySet())
        {
            Campaign campaign = getApplicableCampaign(product);
            if(campaign != null)
            {
                FixedPriceCampaign fixedPriceCampaign = (FixedPriceCampaign) campaign;
                BigDecimal newPrice = product.getPrice().subtract(fixedPriceCampaign.getFixedDiscount(cart.getProducts().size()));
                product.setPrice(newPrice);

            }
        }
        return cart;
    }

    @Override
    public Campaign getApplicableCampaign(Product product) {
        List<Campaign> allFixedCampaignes = getAllFixedCampaignes();
        //
        Campaign applicableCampaign = null;

        for (Campaign campaign : allFixedCampaignes)
        {
            if(isApplicable(product,campaign) && campaign instanceof FixedPriceCampaign)
            {
                applicableCampaign =campaign;
                break;
            }
        }
        return applicableCampaign;
    }
}
