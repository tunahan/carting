package com.trading.dao.product;

import com.trading.domain.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImp implements ProductDao {

    private static ProductDaoImp instance;

    private ProductDaoImp() {
    }

    public static synchronized ProductDaoImp getInstance()
    {
        if(instance == null)
        {
            instance = new ProductDaoImp();
        }
        return instance;
    }

    //mocking
    ArrayList<Product> producsTable = null;

    public void setProducsTable(ArrayList<Product> producsTable) {
        this.producsTable = producsTable;
    }

    public List<Product> getAllProducts() {
        return producsTable;
    }
}
