package com.trading.dao.category;

import com.trading.domain.category.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryDaoImp implements CategoryDao {

    private static CategoryDaoImp instance;

    private CategoryDaoImp() {
    }

    public static synchronized CategoryDaoImp getInstance()
    {
        if(instance == null)
        {
            instance = new CategoryDaoImp();
        }
        return instance;
    }


    //mocking
    private List<Category> categoryTable = null;

    @Override
    public List<Category> getAllCategory() {
        return categoryTable;
    }

    @Override
    public void setAllCategory(List<Category> categoryTable) {
        this.categoryTable = categoryTable;
    }

    @Override
    public Category getCategoryById(long id) {
        List<Category> categoryList = getAllCategory().stream().filter(category1 -> category1.getId() == id).collect(Collectors.toList());
        if(categoryList.size() > 0)
        {
        return categoryList.get(0);

        }else
        {
            return null;
        }
    }
}
