package com.example.webshop.repository;

import com.example.webshop.dto.Address;
import com.example.webshop.dto.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
    // add user
    // add address


    // get by Email
    User findByEmail(String email);

    // getDeliveryAddresses
    @Query(value = "select * from address where :#{#user.id}", nativeQuery = true)
    List<Address> getDeliveryAddresses(@Param("user")User user);
}
