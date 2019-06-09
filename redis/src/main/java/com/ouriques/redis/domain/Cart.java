package com.ouriques.redis.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RedisHash("cart")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cart implements Serializable {

    @Id
    private String id;

    private List<Product> product;

    public Cart() {
        product = new ArrayList<>();
    }
}
