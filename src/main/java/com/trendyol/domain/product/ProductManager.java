package com.trendyol.domain.product;

import com.trendyol.dao.product.ProductDao;
import com.trendyol.domain.campaign.CampaignService;

import java.util.List;

public class ProductManager implements ProductService {

    private ProductDao productDao;
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getAllProducts() {
        List<Product> allProducts =  productDao.getAllProducts();
        return allProducts;
    }

    @Override
    public List<Product> getAllProductsDiscounted(CampaignService campaignService) {
        return null;
    }

//    @Override
//    public List<Product> getAllProductsDiscounted(CampaignService service) {
//        List<Product> productList = productDao.getAllProducts();
//        for(Product product : productList)
//        {
////            if(service.isApplicable(product,c) )
//            product.setPrice(service.getCurrentPrice(product));
//        }
//        return productList;
//    }
}