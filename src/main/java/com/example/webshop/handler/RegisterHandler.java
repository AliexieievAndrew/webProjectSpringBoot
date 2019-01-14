package com.example.webshop.handler;

import com.example.webshop.dto.Address;
import com.example.webshop.dto.Cart;
import com.example.webshop.dto.User;
import com.example.webshop.model.RegisterModel;
import com.example.webshop.repository.AddressRepository;
import com.example.webshop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

// this class is for spring web flow
@Component
public class RegisterHandler {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public AddressRepository addressRepository;

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    public RegisterModel init() {
        return new RegisterModel();
    }

    // for state store the flow instance inside the register model
    public void addUser(RegisterModel registerModel, User user) {
        registerModel.setUser(user);
    }


    // for state store the flow instance inside the register model
    public void addAddress(RegisterModel registerModel, Address billing){
        registerModel.setAddress(billing);
    }


    public String validateUser(User user, MessageContext messageContext) {
        String transitionResponse = "success";

        // checking the password
        if(!(user.getPassword().equals(user.getConfirmPassword()))){

            messageContext.addMessage(new MessageBuilder()
                    .error()
                    // confirmPassword is a path in User.class for form in signup-personal.ftl
                    .source("confirmPassword")
                    .defaultText("password doesn't match the confirm")
                    .build());
            transitionResponse = "failure";
        }

        // check for uniq email
        if (userRepository.findByEmail(user.getEmail())!=null) {
            messageContext.addMessage(new MessageBuilder()
                    .error()
                    // email is a path in User.class for form in signup-personal.ftl
                    .source("email")
                    .defaultText("email address is already used")
                    .build());
            transitionResponse = "failure";
        }
        return transitionResponse;
    }

    public void saveAll(RegisterModel registerModel){
        System.out.println("saveAll working");

        User user = registerModel.getUser();

        // testing
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user.setRole("USER");

        Cart cart = new Cart();
        cart.setUser(user);
        user.setCart(cart);

        userRepository.save(user);

        Address address = registerModel.getAddress();
        address.setUser(user);

        addressRepository.save(address);
    }
}
