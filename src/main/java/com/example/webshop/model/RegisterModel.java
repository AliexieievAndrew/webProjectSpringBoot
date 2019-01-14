package com.example.webshop.model;

import com.example.webshop.dto.Address;
import com.example.webshop.dto.User;

import java.io.Serializable;

// this class is for spring web flow
//3.9.1. Flow Scope
//        Flow scope gets allocated when a flow starts and destroyed when the flow ends.
//        With the default implementation, any objects stored in flow scope need to be Serializable.
// *** should be registered in WebAppInitializer
public class RegisterModel implements Serializable {

    private static final long serialVersionUID = 1l;

    private User user;
    private Address address;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "RegisterModel{" +
                "user=" + user +
                ", address=" + address +
                '}';
    }
}
