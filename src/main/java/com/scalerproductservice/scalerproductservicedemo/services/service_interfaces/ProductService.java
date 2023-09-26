package com.scalerproductservice.scalerproductservicedemo.services.service_interfaces;

import com.scalerproductservice.scalerproductservicedemo.dtos.ProductDto;
import com.scalerproductservice.scalerproductservicedemo.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getASingleProduct(Long productId);

    Product addNewProduct(ProductDto productDto);

    String updateAProduct(Long productId, ProductDto productDto);

    String deleteAProduct(Long productId);
}
