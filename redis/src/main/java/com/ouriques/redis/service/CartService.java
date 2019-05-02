package com.ouriques.redis.service;

import com.ouriques.redis.domain.Cart;
import com.ouriques.redis.domain.Product;
import com.ouriques.redis.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart postCart(Cart cart) throws Exception {

        Cart storedCart = findByUserId(cart.getUserId());

        if(storedCart != null)
            return storedCart;

        return cartRepository.save(cart);
    }

    public void remove(Integer userId) {
        Cart cart = cartRepository.getByUserId(userId);
        cartRepository.delete(cart.getId());
    }

    public Cart findByUserId(Integer userId) throws Exception {

        Cart cart = cartRepository.getByUserId(userId);
        return cart;
    }

    public Cart findAllCartByUserId(Integer userId) throws Exception {

        Cart cart = cartRepository.getByUserId(userId);
        List<Product> products = productService.getByUserId(userId);

        if(cart != null)
            cart.setProducts(products);
        return cart;
    }
}
