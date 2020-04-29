package com.trendyol.domain.campaign.service;

import com.trendyol.domain.campaign.concrete.Campaign;
import com.trendyol.domain.product.Product;

import java.util.List;

public interface CampaignApplicableService {
    List<Campaign> getAllApplicableCampaigns(Product product);

    boolean isApplicable(Product product, Campaign campaign);

    List<Campaign> filterByCartsize(List<Campaign> campaignList, int totalNumberOfProducts);
}
