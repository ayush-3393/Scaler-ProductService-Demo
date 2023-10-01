package com.scalerproductservice.scalerproductservicedemo.services.service_interfaces;

import com.scalerproductservice.scalerproductservicedemo.models.Category;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Optional<List<Category>> getAllCategories();
    Optional<List<Product>> getProductInACategory(Category category);
}
