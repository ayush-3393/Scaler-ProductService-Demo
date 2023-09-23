package com.scalerproductservice.scalerproductservicedemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping()
    public String getAllCategories(){
        return "Getting all categories";
    }
    @GetMapping("/{categoryId}")
    public String getProductInACategory(@PathVariable(name = "categoryId") Long categoryId){
        return "Returning product in a category with id " + categoryId;
    }

}
