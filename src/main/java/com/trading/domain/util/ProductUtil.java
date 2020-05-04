package com.trading.domain.util;

import com.trading.domain.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProductUtil {
    public static ArrayList<Product> getDistinctProductList(HashMap<Product, Integer> products) {
        ArrayList<Product> distinctProductList = new ArrayList<>();
        products.keySet().stream().filter(distinctByKey(Product::getCategoryId)).forEach(distinctProductList::add);
        return distinctProductList;
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
