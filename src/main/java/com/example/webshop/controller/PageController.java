package com.example.webshop.controller;

import com.example.webshop.dto.Category;
import com.example.webshop.dto.Product;
import com.example.webshop.exception.ProductNotFoundException;
import com.example.webshop.repository.CategoryRepository;
import com.example.webshop.repository.ProductRepository;
import com.example.webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PageController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = {"/", "/home", "/index"})
    public String index(Model model) {
        model.addAttribute("title", "Home");
        model.addAttribute("userClick", "home");

        // passing the list of categories
        model.addAttribute("categories", categoryRepository.findAll());

        return "index";
    }

    @GetMapping(value = {"/about"})
    public String about(Model model) {
        model.addAttribute("title", "About");
        model.addAttribute("userClick", "about");
        return "index";
    }

    // no relevant to delete
    @GetMapping(value = {"/allproducts"})
    public String allProducts(Model model) {
        model.addAttribute("title", "All Products");
        model.addAttribute("userClick", "allproducts");
        return "index";
    }

    @GetMapping(value = {"/contact"})
    public String contact(Model model) {
        model.addAttribute("title", "Contact");
        model.addAttribute("userClick", "contact");
        return "index";
    }

    // Get all products and based on category
    @GetMapping(value = "/show/all/products")
    public String getAllProducts(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("title", "All Products");
        model.addAttribute("userClick", "allproducts");
        return "index";
    }

    // get products by category
    @GetMapping(value = "/show/category/{id}/products")
    public String getCategoryProducts(@PathVariable("id") int id, Model model) {
        Category category = null;
        category = categoryRepository.findById(id);

        model.addAttribute("title", category.getName());

        // passing the list of categories
        model.addAttribute("categories", categoryRepository.findAll());

        // passing th category
        model.addAttribute("category", category);

        model.addAttribute("userClick", "allproducts");

        return "index";
    }

    // View a single product
    @GetMapping(value = "/show/{id}/product")
    public String getProductById(@PathVariable("id") int id, Model model) throws ProductNotFoundException {
        Product product = productRepository.findById(id);

        if (product == null)
            throw new ProductNotFoundException();

        model.addAttribute("title", product.getName());
        model.addAttribute("product", product);
        model.addAttribute("userClick", "single_product");

        return "index";
    }

    // login
    @GetMapping(value = {"/login"})
    public String login(@RequestParam(name = "error", required = false) String error, Model model) {

        if (error != null) {
            model.addAttribute("message", "invalid username or password");
        }

        model.addAttribute("title", "login");
        model.addAttribute("userClick", "login");
        return "index";
    }

    // Access Denied
    @GetMapping("/accessDenied")
    public String accessDeniedException(Model model) {
        model.addAttribute("errorTitle", "accessDenied");
        model.addAttribute("errorDescription", "access Denied now :(");
        model.addAttribute("title", "access Denied");
        return "error";
    }
}