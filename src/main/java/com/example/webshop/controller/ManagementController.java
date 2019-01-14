package com.example.webshop.controller;

import com.example.webshop.dto.Category;
import com.example.webshop.dto.Product;
import com.example.webshop.repository.CategoryRepository;
import com.example.webshop.repository.ProductRepository;
import com.example.webshop.util.FileUploadUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/manage")
public class ManagementController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public String showManageProduct(@RequestParam(name = "operation",required = false) String operation, Model model) {
        model.addAttribute("title", "Manage Products");
        model.addAttribute("userClick", "manage_products_freemarker");

        Product nProduct = new Product();

        // set few of the fields
        model.addAttribute("product",nProduct);

        if (operation!= null) {
            if (operation.equals("product")){
                model.addAttribute("message", "element successfully added");
            }
        }

        return "index";
    }

    // for manage Categories
    @GetMapping("/category")
    public String manageCategory(Model model){
        model.addAttribute("title", "Manage Products");
        model.addAttribute("userClick", "new_category");

        Category mCategory = new Category();

        model.addAttribute("category", mCategory);

        return "index";
    }

    @PostMapping("/category")
    public String handleCategorySubmission(@Valid @ModelAttribute("category") Category mCategory, BindingResult result,
                                           Model model){
        categoryRepository.save(mCategory);
        return "redirect:/manage/products";
    }

    // returning categories for all the request mapping
//    @ModelAttribute("categories")
    public Map<String,Integer> getCategories() {
        List<Category> list = (List<Category>) categoryRepository.findAll();
        // needs a Map<value(name)=label(id)>
        return list.stream().collect(Collectors.toMap(Category::getName,Category::getId));
    }

    @ModelAttribute("categories")
    public Map<String,String> getCategoryMap() {
        List<Category> list = (List<Category>) categoryRepository.findAll();
        return list
                .stream()
                .collect(Collectors.toMap(c -> String.valueOf(c.getId()),Category::getName));
    }


    @PostMapping("/products")
    // BindingResult must be before Model
    // @param HttpServletRequest needs to upload file
    public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult result,
                                          Model model, HttpServletRequest request){

        if(result.hasErrors()) {

            model.addAttribute("title", "Manage Products");
            model.addAttribute("userClick", "manage_products_freemarker");
            model.addAttribute("message", "Validation failed");

            return "index";
        }

        if (mProduct.getId() == 0) {

            // creating new product
            productRepository.save(mProduct);
        } else {
            // updating product
            productRepository.save(mProduct);
        }


        // check if the user has uploaded file
        if (!mProduct.getFile().getOriginalFilename().equals("")){
            // mProduct.getFile() - getting abstract file
            // mProduct.getCode() - getting code for create file's name
            FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
        }
        return "redirect:/manage/products?operation=product";
    }

    // edit product
    @GetMapping("/{id}/product")
    public String showEditProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("title", "Manage Products");
        model.addAttribute("userClick", "manage_products_freemarker");

        Product nProduct = productRepository.findById(id);
//        nProduct.setSupplierId(1);
        model.addAttribute("product",nProduct);

        return "index";
    }

    // activating and deactivating product
    @PostMapping("/product/{id}/activation")
    public String handleProductActivation(@PathVariable("id") int id, Model model) {
        Product product = productRepository.findById(id);
        boolean isActive = product.isActive();

        System.out.println("ativation: " +product.getName() + " is " + isActive);
        product.setActive(!product.isActive());
        productRepository.save(product);

        model.addAttribute("title", "Manage Products");
        model.addAttribute("userClick", "manage_products_freemarker");
        return "index";
    }
}
