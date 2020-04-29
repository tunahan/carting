package com.trendyol.domain.util;

import com.trendyol.domain.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProductUtil {
    public static ArrayList<Product> getDistinctProductList(HashMap<Product, Integer> products) {
        ArrayList<Product> distinctProductList = new ArrayList<>();
        products.keySet().stream().filter(distinctByKey(Product::getCategoryId)).forEach(product -> {
            distinctProductList.add(product);
        });
        return distinctProductList;
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
