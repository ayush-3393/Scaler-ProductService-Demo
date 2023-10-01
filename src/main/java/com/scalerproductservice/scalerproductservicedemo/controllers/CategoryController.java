package com.scalerproductservice.scalerproductservicedemo.controllers;

import com.scalerproductservice.scalerproductservicedemo.exceptions.NotFoundException;
import com.scalerproductservice.scalerproductservicedemo.models.Category;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import com.scalerproductservice.scalerproductservicedemo.services.service_interfaces.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategories() throws NotFoundException {
//        List<Category> list = categoryService.getAllCategories();
//        return new ResponseEntity<>(list, HttpStatus.OK);

        Optional<List<Category>> optionalList = categoryService.getAllCategories();
        if (optionalList.isEmpty()){
            throw new NotFoundException("No Categories Found!!");
        }
        return new ResponseEntity<>(optionalList.get(), HttpStatus.OK);
    }


    @GetMapping("/{categoryName}")
    public ResponseEntity<List<Product>> getProductInACategory(@PathVariable(name = "categoryName")
                                                                   String categoryName) throws NotFoundException {
        Category category = new Category();
        category.setName(categoryName);
        Optional<List<Product>> optionalList = categoryService.getProductInACategory(category);
        if (optionalList.isEmpty()){
            throw new NotFoundException("Invalid category name");
        }
        return new ResponseEntity<>(optionalList.get(), HttpStatus.OK);
    }

}
