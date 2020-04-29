package com.trendyol.domain.campaign;

import com.trendyol.domain.product.Product;

import java.util.List;

public interface CampaignApplicableService {
    List<Campaign> getAllApplicableCampaigns(Product product);

    boolean isApplicable(Product product, Campaign campaign);

    List<Campaign> filterByCartsize(List<Campaign> campaignList, int totalNumberOfProducts);
}
