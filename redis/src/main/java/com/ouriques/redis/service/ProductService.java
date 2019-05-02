package com.ouriques.redis.service;

import com.ouriques.redis.domain.Product;
import com.ouriques.redis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getByUserId(Integer userId){
        return productRepository.getByUserId(userId);
    }

    public List<Product> post(List<Product> productList) throws Exception {

        if(productList == null || productList.isEmpty())
            throw new Exception("NENHUM PRODUTO INFORMADO");

        return (List<Product>) productRepository.save(productList);
    }

    public void delete(Product product) {
        productRepository.delete(product.getId());
    }
}
