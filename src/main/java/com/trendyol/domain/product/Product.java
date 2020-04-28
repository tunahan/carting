package com.trendyol.domain.product;

import java.math.BigDecimal;

public class Product {
    private long id;
    private String title;
    BigDecimal price;
    private int categoryId;

    public Product(long id, String title, BigDecimal price, int categoryId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.categoryId = categoryId;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
