package com.trendyol.domain.cart;

import com.trendyol.domain.campaign.CampaignApplicableManager;
import com.trendyol.domain.campaign.CampaignApplicableService;
import com.trendyol.domain.campaign.CampaignManager;
import com.trendyol.domain.coupon.Coupon;
import com.trendyol.domain.coupon.CouponManager;
import com.trendyol.domain.product.Product;

import java.math.BigDecimal;
import java.util.HashMap;

public class Cart {

    public static int MAX_ADDABLE_PRODUCT_NUMBER = 999;
    Coupon coupon;
    CouponManager couponManager = new CouponManager();
    CampaignManager campaignManager;

    HashMap<Product, Integer> products;

    public Cart(CampaignApplicableService campaignApplicableService) {
        this.campaignManager =  new CampaignManager(campaignApplicableService);
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void addProduct(Product product, int amount) {

        boolean found = false;
        for (Product productAlreadyInCart : products.keySet()) {
            if (productAlreadyInCart.getId() == product.getId()) {
                int count = products.get(productAlreadyInCart) + amount;
                products.put(productAlreadyInCart, count);
                found = true;
            }
        }
        if (!found) {
            products.put(product, amount);

        }
    }

    public void removeProduct(long productID) {
        removeProduct(productID,1);
    }
    public void removeProduct(long productID, int amount) {
        for (Product productAlreadyInCart : products.keySet()) {
            if (productAlreadyInCart.getId() == productID) {
                int newCount = products.get(productAlreadyInCart);
                newCount = newCount - amount;
                if (newCount < 1) {
                    products.remove(productAlreadyInCart);
                }else
                {
                    products.put(productAlreadyInCart,newCount);
                }

            }
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
            int numberOfProduct = products.get(product);
            totalValue = totalValue.add(product.getPrice().multiply(BigDecimal.valueOf(numberOfProduct)));
        }
        return totalValue;
    }

    public BigDecimal getTotalAmountAfterCampaigns() {
        BigDecimal totalValue = getTotalAmountNoDiscount();
        totalValue = totalValue.subtract(getCampaignDiscount());
        return totalValue;
    }

    public BigDecimal getTotalAmountAfterCoupon() {
        BigDecimal totalValue = getTotalAmountAfterCampaigns();
        totalValue = totalValue.subtract(getCouponDiscount());
        return totalValue;
    }

    public BigDecimal getCouponDiscount() {
        if (couponManager.isCouponApplicable(this, getCoupon())) {
            return this.couponManager.getDiscountAmount(this, coupon);
        } else {
            return BigDecimal.ZERO;
        }

    }

    public BigDecimal getCampaignDiscount() {
        return campaignManager.getTotalDiscount(this);
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
