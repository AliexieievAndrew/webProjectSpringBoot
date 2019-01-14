package com.example.webshop.repository;

import com.example.webshop.dto.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {
    // add  - save
    // list(get all) - findAll
    // update
    // delete

    Product findById(int id);

    List<Product> findByActiveTrue();

//    listActiveProductsByCategory
    List<Product> findByActiveTrueAndCategoryId(int categoryId);

    // getLatestActiveProduct
    @Query(value = "select top ? * from product is_active = 1 ORDER BY id", nativeQuery = true)
    List<Product> getLatestActiveProduct(int count);
}
