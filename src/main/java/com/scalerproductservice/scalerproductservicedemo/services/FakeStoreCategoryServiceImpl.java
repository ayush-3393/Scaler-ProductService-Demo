package com.scalerproductservice.scalerproductservicedemo.services;

import com.scalerproductservice.scalerproductservicedemo.dtos.AllCategoryDTO;
import com.scalerproductservice.scalerproductservicedemo.dtos.ProductDto;
import com.scalerproductservice.scalerproductservicedemo.dtos.RatingDTO;
import com.scalerproductservice.scalerproductservicedemo.models.Category;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import com.scalerproductservice.scalerproductservicedemo.models.Rating;
import com.scalerproductservice.scalerproductservicedemo.services.service_interfaces.CategoryService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService {

    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreCategoryServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<Category> getAllCategories() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> entity =
                restTemplate.getForEntity("https://fakestoreapi.com/products/categories",
                        String[].class);

        List<Category> ans = new ArrayList<>();

        for (String n : entity.getBody()){
            Category newCategory = new Category();
            newCategory.setName(n);
            ans.add(newCategory);
        }

        return ans;
    }



    @Override
    public List<Product> getProductInACategory(String categoryName) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://fakestoreapi.com/products/category/{categoryName}");
        URI uri = builder.buildAndExpand(categoryName).toUri();

        ResponseEntity<ProductDto[]> entity =
                restTemplate.getForEntity(uri, ProductDto[].class);

        List<Product> ans = new ArrayList<>();

        for (ProductDto productDto : entity.getBody()){
            Product newProduct = new Product();
            newProduct.setId(productDto.getId());
            newProduct.setTitle(productDto.getTitle());
            newProduct.setPrice(productDto.getPrice());
            Category category = new Category();
            category.setName(productDto.getCategory());
            newProduct.setCategory(category);
            newProduct.setDescription(productDto.getDescription());
            newProduct.setImageUrl(productDto.getImage());

//            RatingDTO ratingDto = productDto.getRating();
//
//            Rating r = new Rating();
//
//            r.setRate(ratingDto.getRate());
//            r.setCount(ratingDto.getCount());
//
//            newProduct.setRating(r);

            ans.add(newProduct);
        }
        return ans;

    }
}
