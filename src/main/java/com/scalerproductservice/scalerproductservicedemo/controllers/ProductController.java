package com.scalerproductservice.scalerproductservicedemo.controllers;

import com.scalerproductservice.scalerproductservicedemo.dtos.ProductDto;
import com.scalerproductservice.scalerproductservicedemo.exceptions.NotFoundException;
import com.scalerproductservice.scalerproductservicedemo.models.Category;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import com.scalerproductservice.scalerproductservicedemo.services.service_interfaces.ProductService;
import com.scalerproductservice.scalerproductservicedemo.utility.ProductUtility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts() throws NotFoundException {
        Optional<List<Product>> optionalList = productService.getAllProducts();
        if (optionalList.isEmpty()){
            throw new NotFoundException("No Products Were Found!");
        }
        return optionalList.get();
    }

    @GetMapping("{productId}")
    public ResponseEntity<Product> getASingleProduct(
            @PathVariable(name = "productId") Long productId) throws NotFoundException {

        Optional<Product> productOptional = productService.getASingleProduct(productId);

        if (productOptional.isEmpty()){
            throw new NotFoundException("Product with id " + productId + " was not found!");
        }

        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto) throws NotFoundException {
        Product product = ProductUtility.convertProductDtoToProduct(productDto);
        Optional<Product> optionalProduct = productService.addNewProduct(product);
        if (optionalProduct.isEmpty()){
            throw new NotFoundException("The given product is invalid");
        }
        return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
    }

    @PatchMapping("{productId}")
    public ResponseEntity<Product> updateAProduct(@PathVariable(name = "productId") Long productId,
                                                  @RequestBody ProductDto productDto) throws NotFoundException {
        Product product = ProductUtility.convertProductDtoToProduct(productDto);
        Optional<Product> productOptional = productService.updateAProduct(productId, product);
        if (productOptional.isEmpty()){
            throw new NotFoundException("Invalid product with id " + productId);
        }
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }

    @PutMapping("{productId}")
    public ResponseEntity<Product> replaceAProduct(@PathVariable(name = "productId") Long productId,
                                                  @RequestBody ProductDto productDto) throws NotFoundException {
        Product product = ProductUtility.convertProductDtoToProduct(productDto);
        Optional<Product> productOptional = productService.replaceAProduct(productId, product);
        if (productOptional.isEmpty()){
            throw new NotFoundException("Invalid product with id " + productId);
        }
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Product> deleteAProduct(
                                                @PathVariable(name = "productId") Long productId
                                                ) throws NotFoundException {
        Optional<Product> optionalProduct = productService.deleteAProduct(productId);
        if (optionalProduct.isEmpty()){
            throw new NotFoundException("Product with id " + productId + " was not found");
        }
        return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
    }

}
