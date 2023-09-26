package com.scalerproductservice.scalerproductservicedemo.controllers;

import com.scalerproductservice.scalerproductservicedemo.models.Category;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import com.scalerproductservice.scalerproductservicedemo.services.service_interfaces.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> list = categoryService.getAllCategories();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping("/{categoryName}")
    public ResponseEntity<List<Product>> getProductInACategory(@PathVariable(name = "categoryName")
                                                                   String categoryName){
        List<Product> list = categoryService.getProductInACategory(categoryName);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
