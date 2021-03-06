package com.ouriques.redis.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product implements Serializable {

    private String description;

    private List<Category> category;

    public Product() {
        this.category = new ArrayList<>();
    }
}
