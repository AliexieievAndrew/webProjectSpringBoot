package com.example.webshop.repository;

import com.example.webshop.dto.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository <Cart, Integer> {

}
