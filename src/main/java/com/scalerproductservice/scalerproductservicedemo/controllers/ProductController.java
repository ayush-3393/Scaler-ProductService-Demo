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
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto){
        Product product = productService.addNewProduct(productDto);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PutMapping("{productId}")
    public ResponseEntity<Product> updateAProduct(@PathVariable(name = "productId") Long productId,
                                                  @RequestBody ProductDto productDto){
        Product product = productService.updateAProduct(productId, productDto);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Product> deleteAProduct(@PathVariable(name = "productId") Long productId){
        Product product = productService.deleteAProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
