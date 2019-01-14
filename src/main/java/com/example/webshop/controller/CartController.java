package com.example.webshop.controller;

import com.example.webshop.repository.CartLineRepository;
import com.example.webshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping ("/show")
    public String getShowCart (@RequestParam(name = "result", required = false) String result, Model model) {
        if(result != null){
            switch (result){
                case "updated":
                    model.addAttribute("message","cart was updated");
                    break;
                case "error":
                    model.addAttribute("message","cart not updated: error");
                    break;
                case "deleted":
                    model.addAttribute("message","cart line deleted");
                    break;
                case "added":
                    model.addAttribute("message","you have added product to cart");
                    break;
                case "ordered":
                    model.addAttribute("message","your order has been placed");
                    break;
            }
        }

        model.addAttribute("title","Cart");
        model.addAttribute("userClick", "cart");
        model.addAttribute("cartLines", cartService.getCartLines());

        return "index";
    }

    @GetMapping ("/{id}/update")
    public String updateCount (@PathVariable("id") int cartLineId, @RequestParam(name = "count") int count) {
        String response = cartService.updateCartLine(cartLineId,count);
        return "redirect:/cart/show?" + response;
    }

    @GetMapping ("/{id}/delete")
    public String delete(@PathVariable("id") int cartLineId) {
        String response = cartService.deleteCartLine(cartLineId);

        return "redirect:/cart/show?" + response;
    }
    @GetMapping ("/add/{id}/product")
    public String addCartLine (@PathVariable("id") int productId) {
        String response = cartService.addCartLine(productId);

        return "redirect:/cart/show?" + response;
    }

    @GetMapping("/checkout")
    public  String checkout () {
        String response = cartService.checkout();

        return "redirect:/cart/show?" + response;
    }
}
