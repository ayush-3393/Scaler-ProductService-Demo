package com.scalerproductservice.scalerproductservicedemo.services.service_interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CategoryService {
    String getAllCategories();
    String getProductInACategory(Long categoryId);
}
