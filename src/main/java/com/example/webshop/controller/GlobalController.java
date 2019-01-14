package com.example.webshop.controller;

import com.example.webshop.dto.User;
import com.example.webshop.model.UserModel;
import com.example.webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

/*
 * Сlass to get the user when he logged
 */
@ControllerAdvice // ???????????
public class GlobalController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UserRepository userRepository;

    private UserModel userModel;

    @ModelAttribute("userModel")
    public UserModel getUserModel(){
        userModel = null;
        if (httpSession.getAttribute("userModel") == null) {

            // add the user model
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            // get user by authentication.getName because usersByUsernameQuery set email (in AppSecurityConfig.class)
            User user = userRepository.findByEmail(authentication.getName());

            // create a new userModel
            if (user != null) {
                userModel = new UserModel();

                userModel.setId(user.getId());
                userModel.setEmail(user.getEmail());
                userModel.setFullName(user.getFirstName() + " " + user.getLastName());
                userModel.setRole(user.getRole());
                userModel.setCart(user.getCart());
            }

            // setting the userModel in the session
            httpSession.setAttribute("userModel", userModel);
            return userModel;
        }

        return (UserModel) httpSession.getAttribute("userModel");
    }

}
