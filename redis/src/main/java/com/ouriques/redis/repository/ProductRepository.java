package com.ouriques.redis.repository;

import com.ouriques.redis.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
    List<Product> getByUserId(Integer userId);
}
