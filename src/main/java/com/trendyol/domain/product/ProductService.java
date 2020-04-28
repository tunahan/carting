package com.trendyol.domain.product;

import com.trendyol.domain.campaign.Campaign;
import com.trendyol.domain.campaign.CampaignService;
import com.trendyol.domain.product.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getAllProductsDiscounted(CampaignService campaignService);
}
