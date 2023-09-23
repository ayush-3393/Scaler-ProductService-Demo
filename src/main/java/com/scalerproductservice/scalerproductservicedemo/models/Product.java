package com.scalerproductservice.scalerproductservicedemo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
    private String title;
    private Integer price;
    private String description;
    private Category category;
    private String imageUrl;

}
