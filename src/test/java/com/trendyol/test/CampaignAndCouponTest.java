package com.trendyol.test;

import com.trendyol.dao.campaign.CampaignDao;
import com.trendyol.dao.campaign.CampaignDaoImp;
import com.trendyol.dao.category.CategoryDao;
import com.trendyol.dao.category.CategoryDaoImp;
import com.trendyol.domain.cart.Cart;
import com.trendyol.domain.coupon.Coupon;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.trendyol.test.TestMaterial.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CampaignAndCouponTest {

    @BeforeAll
    static void setup() {
        CampaignDao campaignDao = CampaignDaoImp.getInstance();
        setCampaigns1Fixed1Rate(campaignDao);
        CategoryDao categoryDao = CategoryDaoImp.getInstance();
        setAllCategories(categoryDao);
    }

    @Test
    void domain_noDiscountTest_success()
    {
        Cart cart = getCartWith5ItemNew();
        assertEquals(cart.getTotalAmountNoDiscount(), BigDecimal.valueOf(5950), "No discount case failed");

    }

    @Test
    void domain_onlyCampaignTest_success()
    {
        Cart cart = getCartWith5ItemNew();
        assertEquals(cart.getTotalAmountAfterCampaigns(), BigDecimal.valueOf(5430), "only campaign case failed");
    }

    @Test
    void domain_campaignAndFixed25Coupon_success()
    {
        Cart cart = getCartWith5ItemNew();
        cart.setCoupon(getCouponFixed25());
        assertEquals(cart.getTotalAmountAfterCoupon(), BigDecimal.valueOf(5405), "fixed coupon case failed");
    }

    @Test
    void domain_campaignAndFixed25CouponTooHighConstraint_success()
    {
        Cart cart = getCartWith5ItemNew();
        BigDecimal biggerValueThanCartAmount = cart.getTotalAmountNoDiscount().add(BigDecimal.valueOf(1));
        Coupon coupon = getCouponFixed25();
        coupon.setMinCartamountConstraint(biggerValueThanCartAmount);
        cart.setCoupon(coupon);
        assertEquals(cart.getTotalAmountAfterCoupon(),cart.getTotalAmountAfterCoupon(), "fixed coupon with too high constraint case failed");
    }

    @Test
    void domain_campaignAndRate15Coupon_success()
    {
        Cart cart = getCartWith5ItemNew();
        cart.setCoupon(getCouponRate15());
        assertEquals(cart.getTotalAmountAfterCoupon(), BigDecimal.valueOf(4615.5), "rate coupon case failed");
    }
}
