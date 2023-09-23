package com.scalerproductservice.scalerproductservicedemo.services.service_interfaces;

import com.scalerproductservice.scalerproductservicedemo.dtos.ProductDto;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import org.springframework.web.bind.annotation.*;

public interface ProductService {

    String getAllProducts();

    String getASingleProduct(Long productId);

    String addNewProduct(ProductDto productDto);

    String updateAProduct(Long productId, ProductDto productDto);

    String deleteAProduct(Long productId);
}
