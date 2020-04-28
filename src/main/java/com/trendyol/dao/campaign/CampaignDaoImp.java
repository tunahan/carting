package com.trendyol.dao.campaign;

import com.trendyol.dao.product.ProductDaoImp;
import com.trendyol.domain.campaign.Campaign;
import com.trendyol.domain.product.Product;

import java.util.ArrayList;
import java.util.List;

public class CampaignDaoImp implements CampaignDao {

    private static CampaignDaoImp instance;

    private CampaignDaoImp() {
    }

    public static synchronized CampaignDaoImp getInstance()
    {
        if(instance == null)
        {
            instance = new CampaignDaoImp();
        }
        return instance;
    }

    //mocking
    ArrayList<Campaign> campaignTable = null;

    @Override
    public List<Campaign> getallCampaign() {
        return campaignTable;
    }

    public void setCampaignTable(ArrayList<Campaign> campaignTable) {
        this.campaignTable = campaignTable;
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
