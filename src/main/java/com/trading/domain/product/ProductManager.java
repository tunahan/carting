package com.trading.domain.product;

import com.trading.dao.product.ProductDao;

import java.util.List;

public class ProductManager implements ProductService {

    private final ProductDao productDao;
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
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
