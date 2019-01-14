package com.example.webshop.service;

import com.example.webshop.dto.Cart;
import com.example.webshop.dto.CartLine;
import com.example.webshop.dto.Product;
import com.example.webshop.model.UserModel;
import com.example.webshop.repository.CartLineRepository;
import com.example.webshop.repository.CartRepository;
import com.example.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CartService {

    @Autowired
    CartLineRepository cartLineRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    HttpSession httpSession;

    @Autowired
    ProductRepository productRepository;

    // when user logged userModel != null (look at GlobalController.class)
    private Cart getCart() {
        UserModel userModel = (UserModel) httpSession.getAttribute("userModel");
        return userModel.getCart();
    }

    public List<CartLine> getCartLines() {
        Cart cart = this.getCart();
        return cartLineRepository.listNotOrdered(cart.getId());
    }

    public String updateCartLine(int cartLineId, int count){
        CartLine cartLine = cartLineRepository.findById(cartLineId);

        if (cartLine == null) {
            return "result=error";
        } else {
            Product product = cartLine.getProduct();
            double oldTotal = cartLine.getTotal();

            cartLine.setProductCount(count);
            cartLine.setBuyingPrice(product.getUnitPrice());
            cartLine.setTotal(product.getUnitPrice() * count);

            cartLineRepository.save(cartLine);

            Cart cart = this.getCart();
            cart.setTotal(cart.getTotal() - oldTotal + cartLine.getTotal());

            cartRepository.save(cart);
            return "result=updated";
        }
    }

    public String deleteCartLine(int cartLineId) {
        CartLine cartLine = cartLineRepository.findById(cartLineId);

        if (cartLine == null) {
            return "result=error";
        }

        Cart cart = this.getCart();
        cart.setTotal(cart.getTotal() - cartLine.getTotal());
        cart.setCartLines(cart.getCartLines()-1);

        cartRepository.save(cart);
        cartLineRepository.delete(cartLine);

        return "result=deleted";
    }

    public String addCartLine(int productId) {

        double oldTotal = 0;

        Product product = productRepository.findById(productId);
        Cart cart = this.getCart();
        CartLine cartLine = cartLineRepository.findByCartIdAndProductId(cart.getId(), productId);

        if(cartLine == null) {
            cartLine = new CartLine();

            cartLine.setProduct(product);
            cartLine.setBuyingPrice(product.getUnitPrice());
            cartLine.setCartId(cart.getId());
            cartLine.setProductCount(1);

        } else {
            oldTotal = cartLine.getTotal();
            cartLine.setProductCount(cartLine.getProductCount() + 1);

        }
        cartLine.setTotal(product.getUnitPrice() * cartLine.getProductCount());
        cartLineRepository.save(cartLine);

        cart.setTotal(cart.getTotal() - oldTotal + cartLine.getTotal());
        cart.setCartLines(cart.getCartLines() + 1);

        cartRepository.save(cart);

        return "result=added";
    }

    public String checkout() {
        Cart cart = this.getCart();
        List<CartLine> cartLines = cartLineRepository.findByCartId(cart.getId());
        cartLines.forEach(e -> {
            e.setOrdered(true);
            cartLineRepository.save(e);
        });

        cart.setCartLines(0);
        cartRepository.save(cart);

        return "result=ordered";
    }
}
