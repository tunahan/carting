package com.trendyol.domain.campaign;

import java.math.BigDecimal;

public class FixedPriceCampaign extends Campaign {

    public FixedPriceCampaign(long campaignId, long productId, long categoryId, int minProductNumber, BigDecimal discountFixed) {
        super(campaignId, productId, categoryId, minProductNumber);
        this.discountFixed = discountFixed;
    }

    BigDecimal discountFixed;

    public BigDecimal getDiscountFixed() {
        return discountFixed;
    }

    public void setDiscountFixed(BigDecimal discountFixed) {
        this.discountFixed = discountFixed;
    }

    //    public BigDecimal getFixedDiscount(Integer cartSize) {
//        BigDecimal discount = BigDecimal.ZERO;
//        for(Integer sizeInsideMap : fixedDiscountMap.keySet())
//        {
//            if(cartSize >= sizeInsideMap && discount.compareTo(fixedDiscountMap.get(cartSize)) < 0 )
//            {
//                discount = fixedDiscountMap.get(cartSize);
//            }
//        }
//        return discount;
//    }

}
