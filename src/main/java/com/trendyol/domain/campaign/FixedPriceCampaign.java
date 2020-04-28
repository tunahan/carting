package com.trendyol.domain.campaign;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class FixedPriceCampaign extends Campaign {

    public FixedPriceCampaign(int productId, int categoryId, HashMap<Integer, BigDecimal> fixedDiscountMap) {
        super(productId, categoryId);
        this.fixedDiscountMap = fixedDiscountMap;
    }

    private HashMap<Integer , BigDecimal> fixedDiscountMap;


    public BigDecimal getFixedDiscount(Integer cartSize) {
        BigDecimal discount = BigDecimal.ZERO;
        for(Integer sizeInsideMap : fixedDiscountMap.keySet())
        {
            if(cartSize >= sizeInsideMap && discount.compareTo(fixedDiscountMap.get(cartSize)) < 0 )
            {
                discount = fixedDiscountMap.get(cartSize);
            }
        }
        return discount;
    }

}
