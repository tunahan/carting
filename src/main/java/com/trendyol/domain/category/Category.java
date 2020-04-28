package com.trendyol.domain.category;

import java.util.List;

public class Category {
    private int id;
    private String title;
    private int parentId = 0;
    private List<Category> subCategories;

    public Category(int id, String title, int parentId) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }
}
