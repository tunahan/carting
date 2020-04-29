package com.trading.dao.campaign;

import com.trading.domain.campaign.concrete.Campaign;

import java.util.ArrayList;
import java.util.List;

public interface CampaignDao {
    List<Campaign> getallCampaign();
    Campaign getCampaignByCampaignId(long id);
    void setCampaignTable(ArrayList<Campaign> campaignTable);
}
