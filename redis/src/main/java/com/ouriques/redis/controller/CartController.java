package com.ouriques.redis.controller;

import com.ouriques.redis.builder.CartBuilder;
import com.ouriques.redis.domain.Cart;
import com.ouriques.redis.domain.Product;
import com.ouriques.redis.parser.ProductParser;
import com.ouriques.redis.service.CartService;
import com.ouriques.redis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }


    @PostMapping("/cart/{user_id}")
    public ResponseEntity<Object> postCart(@PathVariable("user_id") Integer userId) {

        Cart cart = null;

        try {

            cart = this.cartService.postCart(CartBuilder.build(userId));

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(cart);

    }

    @PostMapping("/cart/{user_id}/products")
    public ResponseEntity<Object> postProduct(@PathVariable("user_id") Integer userId, @RequestBody List<Product> product) {

        List<Product> list = null;

        try {

            list = this.productService.post(ProductParser.parse(product, userId));

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @DeleteMapping("/cart/{user_id}/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("user_id") Integer userId,
                                                @PathVariable("id") String productId) {

        try {

            this.productService.delete(ProductParser.parse(new Product(), userId, productId));

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @GetMapping("/cart/{user_id}")
    public ResponseEntity<Object> getcart(@PathVariable("user_id") Integer userId) {

        Cart cart = null;

        try {

            cart = this.cartService.findAllCartByUserId(userId);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(cart);

    }

    @DeleteMapping("/cart/{user_id}")
    public ResponseEntity<Object> deleteCart(@PathVariable("user_id") Integer userId) {

        try {

            this.cartService.remove(userId);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
