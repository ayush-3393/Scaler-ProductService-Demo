package com.scalerproductservice.scalerproductservicedemo.clients.fakestoreapis;

import com.scalerproductservice.scalerproductservicedemo.models.Category;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import com.scalerproductservice.scalerproductservicedemo.utility.ProductUtility;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class FakeStoreClient {

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url,
                                                   @Nullable Object request,
                                                   Class<T> responseType,
                                                   Object... uriVariables) throws RestClientException {

        RestTemplate restTemplate = restTemplateBuilder.
                requestFactory(HttpComponentsClientHttpRequestFactory.class)
                .build();

        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return (restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables));
    }

    public List<FakeStoreProductDto> getAllProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> entity =
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/products", FakeStoreProductDto[].class
                );
        return Arrays.asList(entity.getBody());
    }

    public FakeStoreProductDto getASingleProduct(Long productId){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> entity=
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, productId
                );
        return entity.getBody();
    }

    public FakeStoreProductDto addNewProduct(Product product){
        // convert product to fake store product dto
        FakeStoreProductDto fakeStoreProductDto_input =
                ProductUtility.convertProductToFakeStoreDto(product);

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.postForEntity(
                        "https://fakestoreapi.com/products",
                        fakeStoreProductDto_input,
                        FakeStoreProductDto.class
                );
        return response.getBody();
    }

    public FakeStoreProductDto updateAProduct(Long productId, Product product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDto = ProductUtility.convertProductToFakeStoreDto(product);
        ResponseEntity<FakeStoreProductDto> responseEntity= requestForEntity(
                HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                fakeStoreProductDto,
                FakeStoreProductDto.class,
                productId
        );
        return responseEntity.getBody();
    }

    public FakeStoreProductDto replaceAProduct(Long productId, Product product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDto = ProductUtility.convertProductToFakeStoreDto(product);
        ResponseEntity<FakeStoreProductDto> responseEntity= requestForEntity(
                HttpMethod.PUT,
                "https://fakestoreapi.com/products/{id}",
                fakeStoreProductDto,
                FakeStoreProductDto.class,
                productId
        );
        return responseEntity.getBody();
    }

    public FakeStoreProductDto deleteAProduct(Long productId){
        RestTemplate restTemplate = restTemplateBuilder.build();

        FakeStoreProductDto fakeStoreProductDto = getASingleProduct(productId);

        ResponseEntity<FakeStoreProductDto> responseEntity= requestForEntity(
                HttpMethod.DELETE,
                "https://fakestoreapi.com/products/{id}",
                fakeStoreProductDto,
                FakeStoreProductDto.class,
                productId
        );
        return responseEntity.getBody();
    }

    public List<String> getAllCategories(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> response =
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/products/categories",
                        String[].class
                );
        return Arrays.asList(response.getBody());
    }

    public List<FakeStoreProductDto> getProductsInACategory(Category category){
        String category_input= category.getName();
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/products/category/{categoryName}",
                        FakeStoreProductDto[].class,
                        category_input
                );
        return Arrays.asList(responseEntity.getBody());
    }
}
