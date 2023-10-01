package com.scalerproductservice.scalerproductservicedemo.clients.fakestoreapis;

import com.scalerproductservice.scalerproductservicedemo.dtos.RatingDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class FakeStoreProductDto {
    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
    private RatingDto rating;
}
