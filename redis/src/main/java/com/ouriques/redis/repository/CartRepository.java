package com.ouriques.redis.repository;

import com.ouriques.redis.domain.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, String> {

    Cart getByUserId(Integer userId);
    void deleteByUserId(Integer userId);
}
