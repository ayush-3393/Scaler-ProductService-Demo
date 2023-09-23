package com.scalerproductservice.scalerproductservicedemo.services;

import com.scalerproductservice.scalerproductservicedemo.services.service_interfaces.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService {
    @Override
    public String getAllCategories() {
        return null;
    }

    @Override
    public String getProductInACategory(Long categoryId) {
        return null;
    }
}
