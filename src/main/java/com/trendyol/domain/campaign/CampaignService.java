package com.trendyol.domain.campaign;

import com.trendyol.dao.campaign.CampaignDao;
import com.trendyol.dao.campaign.CampaignDaoImp;
import com.trendyol.domain.cart.Cart;
import com.trendyol.domain.product.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public abstract class CampaignService {
    public abstract Cart updateChartWithCampaign(Cart cart);
    public abstract Campaign getApplicableCampaign(Product product);


    List<Campaign> getallCampaignes()
    {
        CampaignDao campaignDao = new CampaignDaoImp();
        return campaignDao.getallCampaign();
    }

    public boolean isApplicable(Product product , Campaign campaign) {
        if (product.getCategoryId() == campaign.getCategoryId() || product.getId() == campaign.getProductId()) {
            return true;
        }
        return false;
    }

    public boolean isApplicable(Cart cart , Campaign campaign) {
        for(Product product : cart.getProducts().keySet())
        if (isApplicable(product,campaign)) {
            return true;
        }
        return false;
    }
}
