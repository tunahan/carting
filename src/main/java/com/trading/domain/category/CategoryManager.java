package com.trading.domain.category;

import com.trading.dao.category.CategoryDaoImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryManager {

    private final CategoryDaoImp dao;
    private final List<Category> daoList;

    public CategoryManager() {
        dao = CategoryDaoImp.getInstance();
        daoList = dao.getAllCategory();
    }

    public List<Category> getSubCategoriesList(long categoryId) {
        Category category = dao.getCategoryById(categoryId);
        if (Optional.ofNullable(category).isPresent()) {
            return getSubCategoriesList(category);
        } else {
            return null;
        }
    }

    private List<Category> getSubCategoriesList(Category category) {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        categoryList = getSubCategoriesList(categoryList);
        return categoryList;

    }

    private List<Category> getSubCategoriesList(List<Category> categoryList) {
        int addedCategory = 0;
        for (Category categoryFromDb : daoList) {
            if (categoryList.stream().anyMatch(categoryComing -> categoryComing.getId() == categoryFromDb.getParentCategoryId())
                    && categoryList.stream().noneMatch(categoryComing -> categoryComing.getId() == categoryFromDb.getId())) {
                categoryList.add(categoryFromDb);
                addedCategory++;
            }
        }

        if (addedCategory == 0) {
            return categoryList;
        } else {
            return getSubCategoriesList(categoryList);
        }
    }
}
