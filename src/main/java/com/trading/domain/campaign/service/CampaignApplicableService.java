package com.trading.domain.campaign.service;

import com.trading.domain.campaign.concrete.Campaign;
import com.trading.domain.product.Product;

import java.util.List;

public interface CampaignApplicableService {
    List<Campaign> getAllApplicableCampaigns(Product product);

    boolean isApplicable(Product product, Campaign campaign);

    List<Campaign> filterByCartsize(List<Campaign> campaignList, int totalNumberOfProducts);
}
