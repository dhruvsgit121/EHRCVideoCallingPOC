package com.EHRC.VideoCalling.Controller;


import com.EHRC.VideoCalling.CustomExceptions.CustomValidationException;
import com.EHRC.VideoCalling.Models.User;
import com.EHRC.VideoCalling.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<String> createUser(@RequestBody User user) {

        System.out.println("values are : " + user.getName() + " rolw is : " + user.getRole());

//        if (user.getName() == null) {
//            System.out.println("entered in name is null");
//            throw new CustomValidationException("User name cannot be null. Please enter valid user name");
//        }

        if (user.getName() == null || user.getName().isEmpty()) {
            throw new CustomValidationException("Username cannot be null or empty");
        }

        if (user.getRole() == null || user.getRole().isEmpty()) {
            throw new CustomValidationException("Userrole cannot be null or empty");
        }

        if (user.getContactNumber() == null || user.getContactNumber().isEmpty()) {
            throw new CustomValidationException("Contact number cannot be null or empty");
        }

        User currentUser = null;
        try {
            currentUser = userService.saveUser(user);
        }
        catch (Exception exception) {
            throw new CustomValidationException(exception.getMessage());
        }

        Map<String, Object> response = new HashMap<>();
        // Assuming the user is created successfully
        response.put("status", "success");
        response.put("message", "User created successfully");
        return ResponseEntity.ok(response.toString());
    }







}
