package com.ouriques.redis.parser;

import com.ouriques.redis.domain.Product;

import java.util.List;

public class ProductParser {

    public static Product parse(Product product, Integer userId){

        product.setUserId(userId);
        return product;
    }

    public static List<Product> parse(List<Product> product, Integer userId){
        product.forEach(data -> data.setUserId(userId));
        return product;
    }

    public static Product parse(Product product, Integer userId, String productId){

        product.setUserId(userId);
        product.setId(productId);

        return product;
    }
}
