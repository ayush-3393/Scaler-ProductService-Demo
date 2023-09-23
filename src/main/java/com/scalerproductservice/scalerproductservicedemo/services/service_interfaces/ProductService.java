package com.scalerproductservice.scalerproductservicedemo.services.service_interfaces;

import com.scalerproductservice.scalerproductservicedemo.dtos.ProductDto;
import com.scalerproductservice.scalerproductservicedemo.dtos.ProductResponseDto;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService {

    ProductResponseDto[] getAllProducts();

    ProductResponseDto getASingleProduct(Long productId);

    ProductResponseDto addNewProduct(ProductDto productDto);

    String updateAProduct(Long productId, ProductDto productDto);

    String deleteAProduct(Long productId);
}
