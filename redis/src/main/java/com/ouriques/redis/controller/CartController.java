package com.ouriques.redis.controller;

import com.ouriques.redis.domain.Cart;
import com.ouriques.redis.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;


    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @PostMapping
    public ResponseEntity<Object> postCart(@RequestBody Cart cart) {

        Cart result = null;

        try {

            result = this.cartService.postCart(cart);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<Object> getcart(@PathVariable("id") String id) {

        Cart cart = null;

        try {

            cart = this.cartService.getById(id);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(cart);

    }

    @GetMapping("/cart")
    public ResponseEntity<Object> getAll() {

        List<Cart> cart = null;

        try {

            cart = this.cartService.getAll();

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(cart);

    }
    @PutMapping
    public ResponseEntity<Object> updateCart(@RequestBody Cart cart) {

        Cart result = null;

        try {

            result = this.cartService.updateCart(cart);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
