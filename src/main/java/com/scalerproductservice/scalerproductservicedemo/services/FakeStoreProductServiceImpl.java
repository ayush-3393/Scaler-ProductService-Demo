package com.scalerproductservice.scalerproductservicedemo.services;

import com.scalerproductservice.scalerproductservicedemo.dtos.ProductDto;
import com.scalerproductservice.scalerproductservicedemo.dtos.ProductResponseDto;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import com.scalerproductservice.scalerproductservicedemo.services.service_interfaces.ProductService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

    private final RestTemplate restTemplate;

    public FakeStoreProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ProductResponseDto[] getAllProducts() {
        return restTemplate.getForObject(
                "https://fakestoreapi.com/products", ProductResponseDto[].class
        );
    }


    @Override
    public ProductResponseDto getASingleProduct(Long productId) {
        return restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId, ProductResponseDto.class
        );
    }

    @Override
    public ProductResponseDto addNewProduct(ProductDto productDto) {
//        return restTemplate.getForObject(
//                "https://fakestoreapi.com/products", ProductResponseDto.class
//        );
        return null;    // need to update
    }

    @Override
    public String updateAProduct(Long productId, ProductDto productDto) {
        return null;
    }

    @Override
    public String deleteAProduct(Long productId) {
        return null;
    }
}
