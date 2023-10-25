package com.scalerproductservice.scalerproductservicedemo.services;

import com.scalerproductservice.scalerproductservicedemo.clients.fakestoreapis.FakeStoreClient;
import com.scalerproductservice.scalerproductservicedemo.clients.fakestoreapis.FakeStoreProductDto;
import com.scalerproductservice.scalerproductservicedemo.models.Category;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import com.scalerproductservice.scalerproductservicedemo.services.service_interfaces.CategoryService;
import com.scalerproductservice.scalerproductservicedemo.utility.ProductUtility;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
public class FakeStoreCategoryServiceImpl implements CategoryService {
    private FakeStoreClient fakeStoreClient;

    public FakeStoreCategoryServiceImpl(FakeStoreClient fakeStoreClient) {
        this.fakeStoreClient = fakeStoreClient;
    }

    @Override
    public Optional<List<Category>> getAllCategories() {
        List<String> list = fakeStoreClient.getAllCategories();
        if (list == null){
            return Optional.empty();
        }
        List<Category> ans = new ArrayList<>();
        for (String category : list){
            Category newCategory = new Category();
            newCategory.setName(category);
            ans.add(newCategory);
        }
        return Optional.of(ans);
    }

    @Override
    public Optional<List<Product>> getProductInACategory(Category category) {
        List<FakeStoreProductDto> list = fakeStoreClient.getProductsInACategory(category);
        if (list == null){
            return Optional.empty();
        }
        List<Product> ans = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : list){
            ans.add(ProductUtility.convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return Optional.of(ans);
    }
}
