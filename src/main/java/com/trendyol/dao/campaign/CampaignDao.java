package com.trendyol.dao.campaign;

import com.trendyol.domain.campaign.Campaign;

import java.util.List;

public interface CampaignDao {
    List<Campaign> getallCampaign();
    Campaign getCampaignByCampaignId(long id);
}
