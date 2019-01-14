package com.example.webshop.dto;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart_line")
public class CartLine implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Product product;

    @Column(name = "cart_id")
    private int cartId;

    @Column(name = "total")
    private double total;

    @Column(name = "product_count")
    private int productCount;

    @Column(name = "buying_price")
    private double buyingPrice;

    @Column (name = "is_ordered")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isOrdered = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public void setOrdered(boolean ordered) {
        isOrdered = ordered;
    }

    @Override
    public String toString() {
        return "CartLine{" +
                "id=" + id +
                ", product=" + product +
                ", cartId=" + cartId +
                ", total=" + total +
                ", productCount=" + productCount +
                ", buyingPrice=" + buyingPrice +
                ", isOrdered=" + isOrdered +
                '}';
    }
}
