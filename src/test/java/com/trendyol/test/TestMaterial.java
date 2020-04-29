package com.trendyol.test;

import com.trendyol.dao.campaign.CampaignDao;
import com.trendyol.dao.category.CategoryDao;
import com.trendyol.domain.campaign.Campaign;
import com.trendyol.domain.campaign.CampaignApplicableManager;
import com.trendyol.domain.campaign.DiscountType;
import com.trendyol.domain.cart.Cart;
import com.trendyol.domain.category.Categories;
import com.trendyol.domain.category.Category;
import com.trendyol.domain.coupon.Coupon;
import com.trendyol.domain.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;

public class TestMaterial {


    public static Coupon getCouponFixed25() {
        Coupon coupon = new Coupon(BigDecimal.valueOf(25), BigDecimal.valueOf(500), DiscountType.FIXED);
        return coupon;
    }

    public static Coupon getCouponRate15() {
        Coupon coupon = new Coupon(BigDecimal.valueOf(15), BigDecimal.valueOf(500), DiscountType.RATE);
        return coupon;
    }


    public static Cart getCartWith5ItemNew() {
        Cart cart = new Cart(new CampaignApplicableManager());
        addItemsElectronic(cart);
        return cart;

    }

    private static void addItemsElectronic(Cart cart) {
        cart.addProduct(new Product(1, "IPad", BigDecimal.valueOf(900), Categories.TABLET));
        cart.addProduct(new Product(2, "Samsung S10 Tablet", BigDecimal.valueOf(550), Categories.TABLET));
        cart.addProduct(new Product(3, "Iphone 7S", BigDecimal.valueOf(800), Categories.PHONE_SMART));
        cart.addProduct(new Product(4, "LG TV", BigDecimal.valueOf(750), Categories.TV_SMART), 4);
        cart.addProduct(new Product(5, "SAMSUNG TV", BigDecimal.valueOf(700), Categories.TV_REGULAR));
    }

    public static void setCampaigns1Fixed1Rate(CampaignDao campaignDao) {
        campaignDao.setCampaignTable(new ArrayList<Campaign>() {
            {
                add(new Campaign(1,0,Categories.PHONE, 2, BigDecimal.valueOf(150), DiscountType.FIXED));
                add(new Campaign(2,0,Categories.TV, 2,BigDecimal.valueOf(10), DiscountType.RATE));
            }
        });
    }

    public static void setAllCategories(CategoryDao categories) {
        categories.setAllCategory(new ArrayList<Category>() {
            {
                add(new Category(Categories.PHONE,"All Phones",Categories.NO_CATEGORY));
                add(new Category(Categories.PHONE_MOBILE,"Mobile Phone",Categories.PHONE));
                add(new Category(Categories.PHONE_SMART,"Smart Phone",Categories.PHONE));
                add(new Category(Categories.PHONE_SMART_IOS,"IOS Phone",Categories.PHONE_SMART));
                add(new Category(Categories.PHONE_SMART_ANDROID,"Android Phone",Categories.PHONE_SMART));
                add(new Category(Categories.TABLET,"All Tablet",Categories.NO_CATEGORY));
                add(new Category(Categories.TV,"All TV",Categories.NO_CATEGORY));
                add(new Category(Categories.TV_SMART,"Smart TV",Categories.TV));
                add(new Category(Categories.TV_REGULAR,"Regular TV",Categories.TV));
                add(new Category(Categories.MONITOR,"Monitor",Categories.NO_CATEGORY));
            }
        });
    }
}
