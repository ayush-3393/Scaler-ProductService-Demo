package com.scalerproductservice.scalerproductservicedemo.services.service_interfaces;

import com.scalerproductservice.scalerproductservicedemo.dtos.ProductDto;
import com.scalerproductservice.scalerproductservicedemo.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<List<Product>> getAllProducts();

    Optional<Product> getASingleProduct(Long productId);

    Optional<Product> addNewProduct(Product product);

    Optional<Product> updateAProduct(Long productId, Product product);

    Optional<Product> replaceAProduct(Long productId, Product product);

    Optional<Product> deleteAProduct(Long productId);
}
