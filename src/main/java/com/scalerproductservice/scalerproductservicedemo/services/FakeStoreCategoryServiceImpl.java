package com.scalerproductservice.scalerproductservicedemo.services;

import com.scalerproductservice.scalerproductservicedemo.dtos.AllCategoryDTO;
import com.scalerproductservice.scalerproductservicedemo.models.Category;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import com.scalerproductservice.scalerproductservicedemo.services.service_interfaces.CategoryService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    public Product getProductInACategory(Long categoryId) {
        return null;
    }
}
