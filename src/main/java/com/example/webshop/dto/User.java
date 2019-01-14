package com.example.webshop.dto;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "user_detail")
public class User implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // mapped by
    // A user has one Cart. A cart has one user.
    // cascade = CascadeType.ALL - helping to auto-creating and adding to DB when using setCart(...);
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Column(name="first_name")
    @NotBlank(message = "Please enter your name")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Please enter your last name")
    private String lastName;

    @Column(name = "role")
    private String role;

    @Column(name = "enabled")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean enabled = true;

    @Column (name = "password")
    @NotBlank(message = "Please enter your password")
    private String password;

    @Transient
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Column (name = "email")
    @NotBlank(message = "Please enter your email")
    @Email(message = "Please enter your correct email")
    private String email;

    @Column (name = "contact_number")
    @NotBlank(message = "Please enter your contact number")
    private String contactNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", enabled=" + enabled +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
