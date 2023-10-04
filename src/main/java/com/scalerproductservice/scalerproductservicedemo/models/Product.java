package com.scalerproductservice.scalerproductservicedemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private Double price;
    private String description;

    @ManyToOne
    private Category category;
    private String imageUrl;

}

/*
Product : Category
    1   ->  1
    m   <-  1
    ---------
    m  <->  1
*/
