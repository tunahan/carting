package com.trendyol.dao.campaign;

import com.trendyol.domain.campaign.Campaign;
import com.trendyol.domain.campaign.PercentageCampaign;
import com.trendyol.domain.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CampaignDaoImp implements CampaignDao {
    @Override
    public List<Campaign> getallCampaign() {
        return new ArrayList<Campaign>() {
            {
                add(new PercentageCampaign(0,5,10));
            }
        };
    }

    @Override
    public Campaign getCampaignByCampaignId(long id) {
        List<Campaign> campaignList = getallCampaign();
        for(Campaign campaign : campaignList)
        {
            if(campaign.getCampaignId() == id)
            {
                return campaign;
            }
        }
        return null;
    }
}
