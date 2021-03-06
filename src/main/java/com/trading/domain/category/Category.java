package com.trading.domain.category;

public class Category {
    private long id;
    private String title;
    private int parentCategoryId;

    public Category(long id, String title, int parentCategoryId) {
        this.id = id;
        this.title = title;
        this.parentCategoryId = parentCategoryId;
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

    public int getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }
}
