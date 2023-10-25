package com.scalerproductservice.scalerproductservicedemo.services;

import com.scalerproductservice.scalerproductservicedemo.models.Category;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import com.scalerproductservice.scalerproductservicedemo.repositories.CategoryRepository;
import com.scalerproductservice.scalerproductservicedemo.repositories.ProductRepository;
import com.scalerproductservice.scalerproductservicedemo.services.service_interfaces.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfCategoryService implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public SelfCategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Optional<List<Category>> getAllCategories() {
        return Optional.of(categoryRepository.findAll());
    }

    @Override
    public Optional<List<Product>> getProductInACategory(Category category) {
        return productRepository.findByCategory(category);
    }
}
