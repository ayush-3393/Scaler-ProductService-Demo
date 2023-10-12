package com.scalerproductservice.scalerproductservicedemo;

import com.scalerproductservice.scalerproductservicedemo.models.Category;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import com.scalerproductservice.scalerproductservicedemo.repositories.CategoryRepository;
import com.scalerproductservice.scalerproductservicedemo.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
public class ProductTests {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void savingProducts(){
        Category category = new Category();
        category.setName("Mobile Phones");
//        Category savedCategory = categoryRepository.save(category);

        Product product = new Product();
        product.setTitle("One Plus 8T");
        product.setPrice((double)42399);
        product.setImageUrl("Image url");
        product.setCategory(category);
        productRepository.save(product);
    }

    @Test
    @Transactional
    void testingFetchingTypes(){
        Optional<Product> productOptional = productRepository.findById(1L);
        if (productOptional.isPresent()){
            System.out.println("Fetched Product");
            Category category = productOptional.get().getCategory();
            System.out.println("Category = " + category.getName());
        }
    }

    @Test
    void removingProducts(){
        productRepository.deleteById(3L);
    }

}
