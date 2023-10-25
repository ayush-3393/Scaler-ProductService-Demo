package com.scalerproductservice.scalerproductservicedemo;

import com.scalerproductservice.scalerproductservicedemo.models.Category;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import com.scalerproductservice.scalerproductservicedemo.repositories.CategoryRepository;
import com.scalerproductservice.scalerproductservicedemo.services.service_interfaces.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CategoryTests {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void addCategory(){
        Category category = new Category();
        category.setName("Sports");
        category.setDescription("Sports related products");
        categoryRepository.save(category);
    }

    @Test
    void testGetAllCategories(){
        Optional<List<Category>> categories = categoryService.getAllCategories();
        if (categories.isEmpty()){
            System.out.println("No categories found");
        }
        else {
            for (Category category : categories.get()){
                System.out.println(category.getName());
            }
        }
    }

    @Test
    @Transactional
    void testGetProductsInACategory(){
        Optional<Category> category = categoryRepository.findByName("Electronics");
        if (category.isEmpty()){
            System.out.println("Category Not Found!");
        }
        else {
            Optional<List<Product>> products = categoryService.getProductInACategory(category.get());
            if (products.isEmpty()){
                System.out.println("No products found");
            }
            else {
                for (Product product : products.get()){
                    System.out.println(product.getTitle());
                }
            }
        }
    }

}
