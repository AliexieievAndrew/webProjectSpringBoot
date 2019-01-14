package com.example.webshop.controller;

import com.example.webshop.dto.Product;
import com.example.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

    @Autowired
    ProductRepository productRepository;


    @GetMapping("/all/products")
    @ResponseBody // help to complete response to JSON (when added dependency)
    public List<Product> getAllProducts() {
        return productRepository.findByActiveTrue();
    }

    // using only for admin !!!
    @GetMapping("/admin/all/products")
    @ResponseBody
    public List<Product> getAllProductsForAdmin() {
        return (List<Product>) productRepository.findAll();
    }

    @GetMapping("/category/{id}/products")
    @ResponseBody
    public List<Product> getProductsByCategory(@PathVariable int id) {
        return productRepository.findByActiveTrueAndCategoryId(id);
    }
}
