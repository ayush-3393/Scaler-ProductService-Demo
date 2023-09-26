package com.scalerproductservice.scalerproductservicedemo.services;

import com.scalerproductservice.scalerproductservicedemo.dtos.ProductDto;
import com.scalerproductservice.scalerproductservicedemo.dtos.RatingDTO;
import com.scalerproductservice.scalerproductservicedemo.models.Category;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import com.scalerproductservice.scalerproductservicedemo.models.Rating;
import com.scalerproductservice.scalerproductservicedemo.services.service_interfaces.ProductService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<Product> getAllProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<ProductDto[]> entity =
                restTemplate.getForEntity("https://fakestoreapi.com/products", ProductDto[].class);

        List<Product> ans = new ArrayList<>();

        for (ProductDto productDto : entity.getBody()){
            Product newProduct = new Product();
            newProduct.setId(productDto.getId());
            newProduct.setTitle(productDto.getTitle());
            newProduct.setPrice(productDto.getPrice());
            Category category = new Category();
            category.setName(productDto.getCategory());
            newProduct.setCategory(category);
            newProduct.setDescription(productDto.getDescription());
            newProduct.setImageUrl(productDto.getImage());

            RatingDTO ratingDto = productDto.getRating();

            Rating r = new Rating();

            r.setRate(ratingDto.getRate());
            r.setCount(ratingDto.getCount());

            newProduct.setRating(r);

            ans.add(newProduct);
        }
        return ans;
    }


    @Override
    public Product getASingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<ProductDto> entity=
        restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductDto.class, productId);

        ProductDto productDto = entity.getBody();

        Product newProduct = new Product();

        newProduct.setId(productDto.getId());
        newProduct.setTitle(productDto.getTitle());
        newProduct.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        newProduct.setCategory(category);
        newProduct.setDescription(productDto.getDescription());
        newProduct.setImageUrl(productDto.getImage());

        RatingDTO ratingDto = productDto.getRating();

        Rating r = new Rating();

        r.setRate(ratingDto.getRate());
        r.setCount(ratingDto.getCount());

        newProduct.setRating(r);

        return newProduct;
    }

    @Override
    public Product addNewProduct(ProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> entity= restTemplate.postForEntity("https://fakestoreapi.com/products",
                productDto,
                ProductDto.class);

        ProductDto productDtoEntity = entity.getBody();

        Product newProduct = new Product();

        newProduct.setId(productDto.getId());
        newProduct.setTitle(productDto.getTitle());
        newProduct.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        newProduct.setCategory(category);
        newProduct.setDescription(productDto.getDescription());
        newProduct.setImageUrl(productDto.getImage());

        // Rating in the input is null, hence skipping that

        return newProduct;
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
