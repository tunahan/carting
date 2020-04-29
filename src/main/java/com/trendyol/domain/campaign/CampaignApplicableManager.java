package com.trendyol.domain.campaign;

import com.trendyol.dao.campaign.CampaignDaoImp;
import com.trendyol.domain.category.Category;
import com.trendyol.domain.category.CategoryManager;
import com.trendyol.domain.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CampaignApplicableManager implements CampaignApplicableService {


    CategoryManager categoryManager = new CategoryManager();

    public CampaignApplicableManager() {
    }

    @Override
    public List<Campaign> getAllApplicableCampaigns(Product product) {
        List<Campaign> allFixedCampaignes = CampaignDaoImp.getInstance().getallCampaign();
        List<Campaign> allApplicableCampaignes = new ArrayList<>();
        for (Campaign campaign : allFixedCampaignes) {
            if (isApplicable(product, campaign)) {
                allApplicableCampaignes.add(campaign);
            }
        }
        return allApplicableCampaignes;
    }

    @Override
    public boolean isApplicable(Product product, Campaign campaign) {
        List<Category> categoryTree = categoryManager.getSubCategoriesList(campaign.getCategoryId());
        if(categoryTree == null) return false;
        boolean anyCategoryMatch = categoryTree.stream().anyMatch(category -> category.getId() == product.getCategoryId());

        if (anyCategoryMatch || product.getId() == campaign.getProductId()) {
                return true;
        }
        return false;
    }

    @Override
    public List<Campaign> filterByCartsize(List<Campaign> campaignList, int totalNumberOfProducts) {
        return  campaignList.stream().filter(campaign -> campaign.getMinProductNumber() <= totalNumberOfProducts)
                .collect(Collectors.toList());
    }
}
