package com.scalerproductservice.scalerproductservicedemo.controllers;

import com.scalerproductservice.scalerproductservicedemo.models.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping()
    public String getAllProducts(){
        return "Returning all the products";
    }

    @GetMapping("{productId}")
    public String getASingleProduct(@PathVariable(name = "productId") Long productId){
        return "Returning a single product with id " + productId;
    }

    @PostMapping()
    public String addNewProduct(@RequestBody Product product){
        return "Adding new Product";
    }

    @PutMapping("{productId}")
    public String updateAProduct(@PathVariable(name = "productId") Long productId, @RequestBody Product product){
        return "Updating a product with id : " + productId + " with product : " + product;
    }

    @DeleteMapping("{productId}")
    public String deleteAProduct(@PathVariable(name = "productId") Long productId){
        return "Deleting a product with id : " + productId;
    }

}
