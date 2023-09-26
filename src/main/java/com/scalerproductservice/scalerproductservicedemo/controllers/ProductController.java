package com.scalerproductservice.scalerproductservicedemo.controllers;

import com.scalerproductservice.scalerproductservicedemo.dtos.ProductDto;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import com.scalerproductservice.scalerproductservicedemo.services.service_interfaces.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("{productId}")
    public ResponseEntity<Product> getASingleProduct(@PathVariable(name = "productId") Long productId){
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                productService.getASingleProduct(productId),
                HttpStatus.OK
        );
        return responseEntity;
    }

    @PostMapping()
    public ProductDto addNewProduct(@RequestBody ProductDto productDto){
        return productService.addNewProduct(productDto);
    }

    @PutMapping("{productId}")
    public String updateAProduct(@PathVariable(name = "productId") Long productId, @RequestBody ProductDto productDto){
        return "Updating a product with id : " + productId + " with product : " + productDto;
    }

    @DeleteMapping("{productId}")
    public String deleteAProduct(@PathVariable(name = "productId") Long productId){
        return "Deleting a product with id : " + productId;
    }

}
