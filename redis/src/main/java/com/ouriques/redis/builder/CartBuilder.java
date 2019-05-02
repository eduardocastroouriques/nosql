package com.ouriques.redis.builder;

import com.ouriques.redis.domain.Cart;

public class CartBuilder {

    public static Cart build(Integer userId){

        Cart cart = new Cart();
        cart.setUserId(userId);

        return cart;
    }
}
