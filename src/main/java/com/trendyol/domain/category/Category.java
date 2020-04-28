package com.trendyol.domain.category;

public class Category {
    private int id;
    private String title;
    private int parentId = 0;

    public Category(int id, String title, int parentId) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getParentId() {
        return parentId;
    }
}
