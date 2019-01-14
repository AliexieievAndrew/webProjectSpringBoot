package com.example.webshop.repository;

import com.example.webshop.dto.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    // add  - save
    // list(get all) - findAll
    // update = save
    // delete
    Category findById(int id);

}
