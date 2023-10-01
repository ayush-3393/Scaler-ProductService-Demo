package com.scalerproductservice.scalerproductservicedemo.utility;

import com.scalerproductservice.scalerproductservicedemo.clients.fakestoreapis.FakeStoreProductDto;
import com.scalerproductservice.scalerproductservicedemo.dtos.ProductDto;
import com.scalerproductservice.scalerproductservicedemo.models.Category;
import com.scalerproductservice.scalerproductservicedemo.models.Product;

public class ProductUtility {
    public static Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product newProduct = new Product();
        newProduct.setId(fakeStoreProductDto.getId());
        newProduct.setTitle(fakeStoreProductDto.getTitle());
        newProduct.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        newProduct.setCategory(category);
        newProduct.setDescription(fakeStoreProductDto.getDescription());
        newProduct.setImageUrl(fakeStoreProductDto.getImage());
        return newProduct;
    }

    public static Product convertProductDtoToProduct(ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setDescription(productDto.getDescription());
        product.setTitle(productDto.getTitle());
        product.setCategory(new Category());
        product.getCategory().setName(productDto.getCategory());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImage());
        return product;
    }

    public static FakeStoreProductDto convertProductToFakeStoreDto(Product product){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        return fakeStoreProductDto;
    }

}
