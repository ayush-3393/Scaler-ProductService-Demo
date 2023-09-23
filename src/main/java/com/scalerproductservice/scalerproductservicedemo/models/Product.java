package com.scalerproductservice.scalerproductservicedemo.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Product extends BaseModel{
    private String title;
    private Double price;
    private String description;
    private Category category;
    private String imageUrl;

}
