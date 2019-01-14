package com.example.webshop.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="cart")
public class Cart implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    // A user has one Cart. A Cart has one user.
    //@Column(name = "user_id") annotation which makes no sense if OneToOne here
    // @JoinColumn(name ="uid") annotation will setting name for column
                                // (only if using hbm2ddl.auto) property
    @OneToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "total")
    private double total;

    @Column(name = "cart_line")
    private int cartLines;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCartLines() {
        return cartLines;
    }

    public void setCartLines(int cartLines) {
        this.cartLines = cartLines;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + user +
                ", total=" + total +
                ", cartLines=" + cartLines +
                '}';
    }
}
