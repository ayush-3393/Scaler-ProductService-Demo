package com.scalerproductservice.scalerproductservicedemo;

import com.scalerproductservice.scalerproductservicedemo.models.Category;
import com.scalerproductservice.scalerproductservicedemo.models.Product;
import com.scalerproductservice.scalerproductservicedemo.repositories.CategoryRepository;
import com.scalerproductservice.scalerproductservicedemo.repositories.ProductRepository;
import com.scalerproductservice.scalerproductservicedemo.services.service_interfaces.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ProductTests {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryRepository categoryRepository;


//    @Autowired
//    private CategoryRepository categoryRepository;

//    private ProductService productService;

//    public ProductTests(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

//    @Test
//    void savingProducts(){
//        Category category = new Category();
//        category.setName("Mobile Phones");
////        Category savedCategory = categoryRepository.save(category);
//
//        Product product = new Product();
//        product.setTitle("One Plus 8T");
//        product.setPrice((double)42399);
//        product.setImageUrl("Image url");
//        product.setCategory(category);
//        productRepository.save(product);
//    }

//    @Test
//    @Transactional
//    void testingFetchingTypes(){
//        Optional<Product> productOptional = productRepository.findById(1L);
//        if (productOptional.isPresent()){
//            System.out.println("Fetched Product");
//            Category category = productOptional.get().getCategory();
//            System.out.println("Category = " + category.getName());
//        }
//    }

//    @Test
//    void removingProducts(){
//        productRepository.deleteById(3L);
//    }

    @Test
    @Transactional
    @Rollback()
    void testGetAllProducts(){
        Category category = new Category();
        category.setName("Mobile Phones");

        Product product = new Product();
        product.setTitle("Samasooong");
        product.setDescription("This is a very bad phone");
        product.setPrice((double)565656);
        product.setImageUrl("Some Image url");
        product.setCategory(category);
        productRepository.save(product);

        product = new Product();
        product.setTitle("Eye Phone -15");
        product.setPrice((double)999999);
        product.setImageUrl("Must Phone Image url");
        product.setDescription("Sell kidney and buy this phone");
        product.setCategory(category);
        productRepository.save(product);

        Optional<List<Product>> optionalList = productService.getAllProducts();

        if (optionalList.isEmpty()){
            System.out.println("No Products Were Found!");
        }
        else{
            List<Product> products = optionalList.get();
            for (Product product1 : products){
                System.out.println(product1.getTitle());
            }
        }

    }

    @Test
    void testGetASingleProduct(){
        Optional<Product> productOptional = productService.getASingleProduct(18L);
        if (productOptional.isEmpty()){
            System.out.println("Product with id " + 18 + " was not found!");
        }
        else{
            Product product = productOptional.get();
            System.out.println(product.getTitle());
        }
    }

    @Test
    void testAddNewProduct(){
//        Category category = new Category();
//        category.setName("Electronics");
//
//        categoryRepository.save(category);

        Optional<Category> category = categoryRepository.findByName("Electronics");
        if (category.isEmpty()){
            System.out.println("Category not found");
            return;
        }

        Product product = new Product();
//        product.setTitle("New EYE Phone -15");
        product.setTitle("MOTO Swami");
//        product.setDescription("Kidney is not required to buy this phone");
        product.setDescription("Better than EYE Phone");
        product.setPrice((double)15000);
        product.setImageUrl("Some Image url");
        product.setCategory(category.get());

        Optional<Product> optionalProduct = productService.addNewProduct(product);

        if (optionalProduct.isEmpty()){
            System.out.println("The given product is invalid");
        }
        else{
            Product product1 = optionalProduct.get();
            System.out.println(product1.getTitle());
        }
    }

    @Test
    void testUpdateAProduct(){
        Optional<Product> productOptional = productRepository.findById(26L);

        if (productOptional.isEmpty()){
            System.out.println("Invalid product with id " + 26);
        }
        else{
            Product product1 = productOptional.get();
            product1.setTitle("VIVO V20 Ultra Pro Max");
            product1.setDescription("This is a very old phone");
            product1.setPrice((double)89765);
            product1.setImageUrl("Some random Image url");
            Optional<Product> updatedProduct = productService.updateAProduct(26L, product1);
            if (updatedProduct.isEmpty()){
                System.out.println("Invalid product with id " + 26);
            }
            else {
                System.out.println(updatedProduct.get().getId());
                System.out.println(updatedProduct.get().getTitle());
            }
        }
    }

    @Test
    void testDeleteAProduct(){
        Optional<Product> optionalProduct = productService.deleteAProduct(1L);
        if (optionalProduct.isEmpty()){
            System.out.println("Product with id " + 1 + " was not found");
        }
        else{
            System.out.println(optionalProduct.get().getTitle() + " was deleted!");
        }
    }

}
