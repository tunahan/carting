package com.trendyol.dao.category;

import com.trendyol.domain.category.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> getAllCategory();
    void setAllCategory(List<Category> campaignTable);
    Category getCategoryById(long id);
}
