package com.scalerproductservice.scalerproductservicedemo.services;

import com.scalerproductservice.scalerproductservicedemo.models.Product;
import com.scalerproductservice.scalerproductservicedemo.repositories.ProductRepository;
import com.scalerproductservice.scalerproductservicedemo.services.service_interfaces.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfProductService implements ProductService {

    private final ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Optional<List<Product>> getAllProducts() {
        return Optional.of(productRepository.findAll());
    }

    @Override
    public Optional<Product> getASingleProduct(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Optional<Product> addNewProduct(Product product) {
        return Optional.of(productRepository.save(product));
    }

    @Override
    public Optional<Product> updateAProduct(Long productId, Product product) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isEmpty()){
            return Optional.empty();
        }
        Product productFromDb = productOptional.get();

        productFromDb.setTitle(product.getTitle());
        productFromDb.setDescription(product.getDescription());
        productFromDb.setPrice(product.getPrice());
        productFromDb.setImageUrl(product.getImageUrl());
        productFromDb.setCategory(product.getCategory());
        return Optional.of(productRepository.save(productFromDb));
    }

    @Override
    public Optional<Product> replaceAProduct(Long productId, Product product) {
        // replace a product in the table



        return Optional.empty();
    }

    @Override
    public Optional<Product> deleteAProduct(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()){
            return Optional.empty();
        }
        Product product = productOptional.get();
        product.setIsDeleted(true);
        return Optional.of(productRepository.save(product));


//        productRepository.deleteById(productId);
//        return productOptional;
    }
}
