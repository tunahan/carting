package com.trendyol.test;

import com.trendyol.dao.campaign.CampaignDao;
import com.trendyol.dao.campaign.CampaignDaoImp;
import com.trendyol.dao.category.CategoryDao;
import com.trendyol.dao.category.CategoryDaoImp;
import com.trendyol.domain.category.Category;
import com.trendyol.domain.category.CategoryManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.trendyol.test.TestMaterial.setAllCategories;
import static com.trendyol.test.TestMaterial.setCampaigns1Fixed1Rate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShipmentTest {

    @BeforeAll
    static void setup() {
        CampaignDao campaignDao = CampaignDaoImp.getInstance();
        setCampaigns1Fixed1Rate(campaignDao);
        CategoryDao categoryDao = CategoryDaoImp.getInstance();
        setAllCategories(categoryDao);
    }

//    @Test
//    void test_category() {
//        CategoryManager categoryManager = new CategoryManager();
//        CategoryDao categoryDao = CategoryDaoImp.getInstance();
//        Category category = categoryDao.getCategoryById(1);
//        List<Category> categoryTree = categoryManager.getSubCategoriesList(category);
//        assertEquals(1, 1);
//    }
}
