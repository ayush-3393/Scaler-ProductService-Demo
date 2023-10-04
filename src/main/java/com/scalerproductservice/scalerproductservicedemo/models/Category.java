package com.scalerproductservice.scalerproductservicedemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Category extends BaseModel{
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;
}

/*
Product : Category
    1   ->  1
    m   <-  1
    ---------
    m  <->  1
*/