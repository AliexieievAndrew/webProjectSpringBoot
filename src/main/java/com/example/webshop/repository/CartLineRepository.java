package com.example.webshop.repository;

import com.example.webshop.dto.Cart;
import com.example.webshop.dto.CartLine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartLineRepository extends CrudRepository<CartLine, Integer> {
    // add(save)
    // get
    // update(save)
    // delete

    /*
     *  METHOD UPDATE
     *  automatically does updating.
     *  If the entity is new it will call persist on the entity manager, otherwise it will call merge
     */
    CartLine findById(int id);

    List<CartLine> findByCartId(int cartId);

    @Query(value = "select * from cart_line WHERE cart_id = ? AND is_ordered = 0", nativeQuery = true)
    List<CartLine> listNotOrdered(int cartId);

//    @Query(value = "select * from Message WHERE cart_id = ? AND product_id = ?", nativeQuery = true)
    CartLine findByCartIdAndProductId(int cartId, int productId);

}
