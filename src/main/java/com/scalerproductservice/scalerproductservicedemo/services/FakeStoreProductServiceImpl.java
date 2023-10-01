package com.scalerproductservice.scalerproductservicedemo.services;

import com.scalerproductservice.scalerproductservicedemo.clients.fakestoreapis.FakeStoreClient;
import com.scalerproductservice.scalerproductservicedemo.clients.fakestoreapis.FakeStoreProductDto;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import com.scalerproductservice.scalerproductservicedemo.services.service_interfaces.ProductService;
import com.scalerproductservice.scalerproductservicedemo.utility.ProductUtility;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreProductServiceImpl implements ProductService {
    private FakeStoreClient fakeStoreClient;

    public FakeStoreProductServiceImpl(FakeStoreClient fakeStoreClient) {
        this.fakeStoreClient = fakeStoreClient;
    }

    @Override
    public Optional<List<Product>> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreClient.getAllProducts();
        List<Product> ans = new ArrayList<>();
        for (FakeStoreProductDto productDto : fakeStoreProductDtos){
            Product newProduct = ProductUtility.convertFakeStoreProductDtoToProduct(productDto);
            ans.add(newProduct);
        }
        return Optional.of(ans);
    }

    @Override
    public Optional<Product> getASingleProduct(Long productId) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.getASingleProduct(productId);
        if (fakeStoreProductDto == null){
            return Optional.empty();
        }
        return Optional.of(ProductUtility.convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
    }

    @Override
    public Optional<Product> addNewProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto_output = fakeStoreClient.addNewProduct(product);
        if (fakeStoreProductDto_output == null){
            return Optional.empty();
        }
        return Optional.of(ProductUtility.convertFakeStoreProductDtoToProduct(fakeStoreProductDto_output));
    }

    @Override
    public Optional<Product> updateAProduct(Long productId, Product product) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.updateAProduct(productId, product);
        if (fakeStoreProductDto == null){
            return Optional.empty();
        }
        return Optional.of(ProductUtility.convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
    }

    @Override
    public Optional<Product> replaceAProduct(Long productId, Product product) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.updateAProduct(productId, product);
        if (fakeStoreProductDto == null){
            return Optional.empty();
        }
        return Optional.of(ProductUtility.convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
    }

    @Override
    public Optional<Product> deleteAProduct(Long productId) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.deleteAProduct(productId);
        if (fakeStoreProductDto == null){
            return Optional.empty();
        }
        return Optional.of(ProductUtility.convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
    }
}
