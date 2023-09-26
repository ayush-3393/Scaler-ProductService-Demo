package com.scalerproductservice.scalerproductservicedemo.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ProductDto {
    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
    private RatingDTO rating;
}
