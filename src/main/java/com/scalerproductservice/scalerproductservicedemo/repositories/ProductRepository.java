package com.scalerproductservice.scalerproductservicedemo.repositories;

import com.scalerproductservice.scalerproductservicedemo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    void deleteById(Long id);
}
