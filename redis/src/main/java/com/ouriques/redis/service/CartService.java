package com.ouriques.redis.service;

import com.ouriques.redis.domain.Cart;
import com.ouriques.redis.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart postCart(Cart cart) throws Exception {
        return cartRepository.save(cart);
    }

    public Cart updateCart(Cart cart) throws Exception {
        return cartRepository.save(cart);
    }

    public Cart getById(String id) throws Exception {
        return cartRepository.findOne(id);
    }
}
