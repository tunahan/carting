package com.trendyol.domain.cart;

import com.trendyol.domain.campaign.CampaignService;
import com.trendyol.domain.coupon.Coupon;
import com.trendyol.domain.coupon.CouponService;
import com.trendyol.domain.product.Product;

import java.math.BigDecimal;
import java.util.HashMap;

public class Cart {

    public static int MAX_ADDABLE_PRODUCT_NUMBER = 999;
    CampaignService campaignService;
    CouponService couponService;
    Coupon coupon;

    HashMap<Product, Integer> products;

    public Cart(CampaignService campaignService, CouponService couponService) {
        this.campaignService = campaignService;
        this.couponService = couponService;
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        addProductWithQuantity(product, 1);
    }

    public void addProductWithQuantity(Product product, int amount) {

        boolean found = false;
        for (Product productAlreadyInCart : products.keySet()) {
            if (productAlreadyInCart.getId() == product.getId()) {
                Integer count = products.get(productAlreadyInCart);
                count = count + amount;
                found = true;
            }
        }
        if (!found) {
            products.put(product, amount);

        }
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }

    public BigDecimal getTotalAmountNoDiscount() {
        BigDecimal totalValue = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            int numberOfProduct = products.size();
            totalValue = totalValue.add(product.getPrice().multiply(BigDecimal.valueOf(numberOfProduct)));
        }
        return totalValue;
    }

    public BigDecimal getTotalAmountAfterDiscounts() {
        BigDecimal totalValue = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            int numberOfProduct = products.size();
            totalValue = totalValue.add(product.getPrice().multiply(BigDecimal.valueOf(numberOfProduct)));
        }
        return totalValue;
    }

    public BigDecimal getCouponDiscount() {
        if (couponService.isCouponApplicable(this, getCoupon())) {
            return this.couponService.getDiscountAmount(this, coupon);
        } else {
            return BigDecimal.ZERO;
        }

    }

    public BigDecimal getCampaignDiscount() {
        return campaignService.getTotalDiscount(this);
    }

    public int getTotalNumberOfProducts() {
        int totalNumber = 0;
        for (Integer numOfProduct : products.values()) {
            totalNumber = totalNumber + numOfProduct;
        }
        return totalNumber;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }
}
