package com.trendyol.domain.campaign;

import com.trendyol.dao.campaign.CampaignDao;
import com.trendyol.dao.campaign.CampaignDaoImp;
import com.trendyol.domain.cart.Cart;
import com.trendyol.domain.product.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public abstract class CampaignService {
    public abstract BigDecimal getTotalDiscount(Cart cart);

//    public abstract Campaign getBestCampaign(Product product, int cartSize);

    public abstract List<Campaign> getAllApplicableCampaigns(Product product, int cartSize);
    public abstract List<Campaign> getAllApplicableCampaigns(Cart cart);


    List<Campaign> getallCampaignes() {
        CampaignDao campaignDao = CampaignDaoImp.getInstance();
        return campaignDao.getallCampaign();
    }

    public boolean isApplicable(Product product, Campaign campaign, int cartSize) {
        if (product.getCategoryId() == campaign.getCategoryId() || product.getId() == campaign.getProductId()) {
            if (campaign.getMinProductNumber() >= cartSize) {
                return true;
            }
        }
        return false;
    }
}
